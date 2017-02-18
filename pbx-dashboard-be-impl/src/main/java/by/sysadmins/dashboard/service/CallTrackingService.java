package by.sysadmins.dashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import by.sysadmins.dashboard.dto.InboundRouteDto;

@Service
public class CallTrackingService {

    @Autowired
    private DataSourceEmployment dataSourceEmployment;

    public List<InboundRouteDto> getPrefixList(String username) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceEmployment.getDateSourceByUsername(username, "asterisk"));
        List<InboundRouteDto> inboundRoutes = jdbcTemplate.query(
                "SELECT * FROM incoming i WHERE 1", (rs, rowNum) -> {
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
