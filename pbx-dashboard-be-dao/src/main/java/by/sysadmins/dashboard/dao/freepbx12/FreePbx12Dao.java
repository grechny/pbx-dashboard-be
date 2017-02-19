package by.sysadmins.dashboard.dao.freepbx12;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import by.sysadmins.dashboard.dao.DataSourceManager;
import by.sysadmins.dashboard.dao.freepbx.FreePbxDao;
import by.sysadmins.dashboard.dao.freepbx.connectivity.InboundRoutesDao;
import by.sysadmins.dashboard.dao.freepbx.connectivity.OutboundRoutesDao;
import by.sysadmins.dashboard.dao.freepbx.connectivity.TrunksDao;
import by.sysadmins.dashboard.dao.freepbx12.connectivity.FreePbx12InboundRoutesDao;
import by.sysadmins.dashboard.dao.freepbx12.connectivity.FreePbx12OutboundRoutesDao;
import by.sysadmins.dashboard.dao.freepbx12.connectivity.FreePbx12TrunksDao;

@Component
@Qualifier(value = "freePbx12Dao")
public class FreePbx12Dao implements FreePbxDao {

    private final DataSourceManager dataSourceManager;

    @Autowired
    public FreePbx12Dao(DataSourceManager dataSourceManager) {
        this.dataSourceManager = dataSourceManager;
    }

    @Override
    public InboundRoutesDao getInboundRoutesDao(String username) {
        DataSource dataSource = dataSourceManager.getDateSourceByUsername(username, ASTERISK_DB_NAME);
        return new FreePbx12InboundRoutesDao(dataSource);
    }

    @Override
    public OutboundRoutesDao getOutboundRoutesDao(String username) {
        DataSource dataSource = dataSourceManager.getDateSourceByUsername(username, ASTERISK_DB_NAME);
        return new FreePbx12OutboundRoutesDao(dataSource);
    }

    @Override
    public TrunksDao getTrunksDao(String username) {
        DataSource dataSource = dataSourceManager.getDateSourceByUsername(username, ASTERISK_DB_NAME);
        return new FreePbx12TrunksDao(dataSource);
    }
}
