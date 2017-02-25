package by.sysadmins.dashboard.dao.freepbx.connectivity;

import org.apache.tomcat.jdbc.pool.DataSource;

public abstract class TrunksDao {

    protected DataSource dataSource;

    public TrunksDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
