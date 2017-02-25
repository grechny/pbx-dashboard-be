package by.sysadmins.dashboard.dao.freepbx13.connectivity;

import org.apache.tomcat.jdbc.pool.DataSource;

import by.sysadmins.dashboard.dao.freepbx.connectivity.OutboundRoutesDao;

public class FreePbx13OutboundRoutesDao extends OutboundRoutesDao {

    public FreePbx13OutboundRoutesDao(DataSource dataSource) {
        super(dataSource);
    }

}
