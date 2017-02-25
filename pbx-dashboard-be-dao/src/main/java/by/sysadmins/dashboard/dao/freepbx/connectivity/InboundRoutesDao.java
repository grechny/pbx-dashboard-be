package by.sysadmins.dashboard.dao.freepbx.connectivity;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.util.List;

import by.sysadmins.dashboard.dto.InboundRouteDto;

public abstract class InboundRoutesDao {

    private final static String FIND_ALL_QUERY = "SELECT * FROM incoming";

    protected DataSource dataSource;

    public InboundRoutesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<InboundRouteDto> findAll() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<InboundRouteDto> inboundRoutes = jdbcTemplate.query(FIND_ALL_QUERY, (ResultSet rs, int rowNum) -> {
            InboundRouteDto pbxInboundRoute = new InboundRouteDto();
            pbxInboundRoute.setDescription(rs.getString("description"));
            pbxInboundRoute.setPrefix(rs.getString("grppre"));
            String[] destination = rs.getString("destination").split(",");
            pbxInboundRoute.setDestination(destination[1]);
            switch (destination[0]) {
                case "from-did-direct":
                    pbxInboundRoute.setDestinationType("extension");
                    break;
                case "ext-queues":
                    pbxInboundRoute.setDestinationType("queue");
                    break;
                case "timeconditions":
                    pbxInboundRoute.setDestinationType("time condition");
                    break;
                default:
                    pbxInboundRoute.setDestinationType("unknown");
            }
            return pbxInboundRoute;
        });
        return inboundRoutes;
    }
}
