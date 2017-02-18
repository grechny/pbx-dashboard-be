package by.sysadmins.dashboard.dao.freepbx;

import by.sysadmins.dashboard.dao.freepbx.connectivity.InboundRoutesDao;
import by.sysadmins.dashboard.dao.freepbx.connectivity.OutboundRoutesDao;
import by.sysadmins.dashboard.dao.freepbx.connectivity.TrunksDao;

public interface FreePbxDao {
    InboundRoutesDao getInboundRoutesDao();

    OutboundRoutesDao getOutboundRoutesDao();

    TrunksDao getTrunksDao();
}
