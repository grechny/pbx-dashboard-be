package by.sysadmins.dashboard.dao;

import by.sysadmins.dashboard.dao.freepbx.FreePbxDao;
import by.sysadmins.dashboard.dao.freepbx.v12.FreePbx12Dao;
import by.sysadmins.dashboard.dao.freepbx.v13.FreePbx13Dao;

public class FreePbxDaoFactory {

    public static FreePbxDao getDaoFactory(FreePBX version) {
        switch (version) {
            case V12:
                return new FreePbx12Dao();
            case V13:
                return new FreePbx13Dao();
            default:
                throw new UnsupportedOperationException("This version of FreePBX does not supported yet");
        }
    }

    public enum FreePBX{
        V12, V13
    }

}
