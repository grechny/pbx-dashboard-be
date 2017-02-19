package by.sysadmins.dashboard.dao.freepbx13.connectivity;

import org.apache.tomcat.jdbc.pool.DataSource;

import by.sysadmins.dashboard.dao.freepbx.connectivity.InboundRoutesDao;
import by.sysadmins.dashboard.dto.InboundRouteDto;

public class FreePbx13InboundRoutesDao extends InboundRoutesDao {

    public FreePbx13InboundRoutesDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void create(InboundRouteDto entity) {
        //todo implement method
    }

    @Override
    public void update(InboundRouteDto entity) {
        //todo implement method
    }

    @Override
    public void delete(InboundRouteDto entity) {
        //todo implement method
    }
}
