package by.sysadmins.dashboard.dao.freepbx;

import by.sysadmins.dashboard.dao.freepbx.connectivity.InboundRoutesDao;
import by.sysadmins.dashboard.dao.freepbx.connectivity.OutboundRoutesDao;
import by.sysadmins.dashboard.dao.freepbx.connectivity.TrunksDao;

public interface FreePbxDao {
    String ASTERISK_DB_NAME = "asterisk";
    String CDR_DB_NAME = "asteriskcdrdb";

    InboundRoutesDao getInboundRoutesDao(String username);

    OutboundRoutesDao getOutboundRoutesDao(String username);

    TrunksDao getTrunksDao(String username);
}
