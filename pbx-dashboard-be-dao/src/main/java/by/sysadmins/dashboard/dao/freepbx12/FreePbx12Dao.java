package by.sysadmins.dashboard.dao.freepbx12;

import by.sysadmins.dashboard.dao.freepbx.FreePbxDao;
import by.sysadmins.dashboard.dao.freepbx.connectivity.InboundRoutesDao;
import by.sysadmins.dashboard.dao.freepbx.connectivity.OutboundRoutesDao;
import by.sysadmins.dashboard.dao.freepbx.connectivity.TrunksDao;
import by.sysadmins.dashboard.dao.freepbx12.connectivity.FreePbx12InboundRoutesDao;
import by.sysadmins.dashboard.dao.freepbx12.connectivity.FreePbx12OutboundRoutesDao;
import by.sysadmins.dashboard.dao.freepbx12.connectivity.FreePbx12TrunksDao;

public class FreePbx12Dao implements FreePbxDao {

    @Override
    public InboundRoutesDao getInboundRoutesDao() {
        return new FreePbx12InboundRoutesDao();
    }

    @Override
    public OutboundRoutesDao getOutboundRoutesDao() {
        return new FreePbx12OutboundRoutesDao();
    }

    @Override
    public TrunksDao getTrunksDao() {
        return new FreePbx12TrunksDao();
    }
}
