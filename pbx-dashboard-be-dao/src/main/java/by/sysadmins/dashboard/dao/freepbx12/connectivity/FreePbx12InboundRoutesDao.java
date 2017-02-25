package by.sysadmins.dashboard.dao.freepbx12.connectivity;

import org.apache.tomcat.jdbc.pool.DataSource;

import by.sysadmins.dashboard.dao.freepbx.connectivity.InboundRoutesDao;

public class FreePbx12InboundRoutesDao extends InboundRoutesDao {

    public FreePbx12InboundRoutesDao(DataSource dataSource) {
        super(dataSource);
    }

}
