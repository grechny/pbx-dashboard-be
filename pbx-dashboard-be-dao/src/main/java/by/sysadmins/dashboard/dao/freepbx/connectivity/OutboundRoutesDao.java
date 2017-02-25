package by.sysadmins.dashboard.dao.freepbx.connectivity;

import org.apache.tomcat.jdbc.pool.DataSource;

public abstract class OutboundRoutesDao {

    protected DataSource dataSource;

    public OutboundRoutesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
