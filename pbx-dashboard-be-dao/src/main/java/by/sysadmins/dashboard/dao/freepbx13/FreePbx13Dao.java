package by.sysadmins.dashboard.dao.freepbx13;

import by.sysadmins.dashboard.dao.freepbx.FreePbxDao;
import by.sysadmins.dashboard.dao.freepbx.connectivity.InboundRoutesDao;
import by.sysadmins.dashboard.dao.freepbx.connectivity.OutboundRoutesDao;
import by.sysadmins.dashboard.dao.freepbx.connectivity.TrunksDao;
import by.sysadmins.dashboard.dao.freepbx13.connectivity.FreePbx13InboundRoutesDao;
import by.sysadmins.dashboard.dao.freepbx13.connectivity.FreePbx13OutboundRoutesDao;
import by.sysadmins.dashboard.dao.freepbx13.connectivity.FreePbx13TrunksDao;

public class FreePbx13Dao implements FreePbxDao {

    @Override
    public InboundRoutesDao getInboundRoutesDao() {
        return new FreePbx13InboundRoutesDao();
    }

    @Override
    public OutboundRoutesDao getOutboundRoutesDao() {
        return new FreePbx13OutboundRoutesDao();
    }

    @Override
    public TrunksDao getTrunksDao() {
        return new FreePbx13TrunksDao();
    }
}
