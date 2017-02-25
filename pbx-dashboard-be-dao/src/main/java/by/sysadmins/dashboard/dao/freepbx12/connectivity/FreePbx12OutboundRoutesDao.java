package by.sysadmins.dashboard.dao.freepbx12.connectivity;

import org.apache.tomcat.jdbc.pool.DataSource;

import by.sysadmins.dashboard.dao.freepbx.connectivity.OutboundRoutesDao;

public class FreePbx12OutboundRoutesDao extends OutboundRoutesDao {

    public FreePbx12OutboundRoutesDao(DataSource dataSource) {
        super(dataSource);
    }

}
