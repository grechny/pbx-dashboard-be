package by.sysadmins.dashboard.dao.freepbx.connectivity;

import org.apache.tomcat.jdbc.pool.DataSource;

import by.sysadmins.dashboard.dao.GenericDaoOperations;

public abstract class OutboundRoutesDao implements GenericDaoOperations {

    protected DataSource dataSource;

    public OutboundRoutesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
