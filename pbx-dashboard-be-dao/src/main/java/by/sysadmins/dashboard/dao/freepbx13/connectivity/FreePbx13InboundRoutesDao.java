package by.sysadmins.dashboard.dao.freepbx13.connectivity;

import org.apache.tomcat.jdbc.pool.DataSource;

import by.sysadmins.dashboard.dao.freepbx.connectivity.InboundRoutesDao;

public class FreePbx13InboundRoutesDao extends InboundRoutesDao {

    public FreePbx13InboundRoutesDao(DataSource dataSource) {
        super(dataSource);
    }


}
