package by.sysadmins.dashboard.dao.freepbx13;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import by.sysadmins.dashboard.dao.DataSourceManager;
import by.sysadmins.dashboard.dao.freepbx.FreePbxDao;
import by.sysadmins.dashboard.dao.freepbx.connectivity.InboundRoutesDao;
import by.sysadmins.dashboard.dao.freepbx.connectivity.OutboundRoutesDao;
import by.sysadmins.dashboard.dao.freepbx.connectivity.TrunksDao;
import by.sysadmins.dashboard.dao.freepbx13.connectivity.FreePbx13InboundRoutesDao;
import by.sysadmins.dashboard.dao.freepbx13.connectivity.FreePbx13OutboundRoutesDao;
import by.sysadmins.dashboard.dao.freepbx13.connectivity.FreePbx13TrunksDao;

@Component
@Qualifier(value = "freePbx13Dao")
public class FreePbx13Dao implements FreePbxDao {

    private final DataSourceManager dataSourceManager;

    @Autowired
    public FreePbx13Dao(DataSourceManager dataSourceManager) {
        this.dataSourceManager = dataSourceManager;
    }

    @Override
    public InboundRoutesDao getInboundRoutesDao(String username) {
        DataSource dataSource = dataSourceManager.getDateSourceByUsername(username, ASTERISK_DB_NAME);
        return new FreePbx13InboundRoutesDao(dataSource);
    }

    @Override
    public OutboundRoutesDao getOutboundRoutesDao(String username) {
        DataSource dataSource = dataSourceManager.getDateSourceByUsername(username, ASTERISK_DB_NAME);
        return new FreePbx13OutboundRoutesDao(dataSource);
    }

    @Override
    public TrunksDao getTrunksDao(String username) {
        DataSource dataSource = dataSourceManager.getDateSourceByUsername(username, ASTERISK_DB_NAME);
        return new FreePbx13TrunksDao(dataSource);
    }
}
