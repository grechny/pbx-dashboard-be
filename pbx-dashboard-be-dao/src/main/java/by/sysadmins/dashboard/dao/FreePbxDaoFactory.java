package by.sysadmins.dashboard.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import by.sysadmins.dashboard.dao.freepbx.FreePbxDao;

@Component
public class FreePbxDaoFactory {

    private final FreePbxDao freePbx12Dao;
    private final FreePbxDao freePbx13Dao;

    @Autowired
    public FreePbxDaoFactory(@Qualifier(value = "freePbx12Dao") FreePbxDao freePbx13Dao,
                             @Qualifier(value = "freePbx13Dao") FreePbxDao freePbx12Dao) {
        this.freePbx13Dao = freePbx13Dao;
        this.freePbx12Dao = freePbx12Dao;
    }

    public FreePbxDao getDaoFactory(FreePBX version) {
        switch (version) {
            case V12:
                return freePbx12Dao;
            case V13:
                return freePbx13Dao;
            default:
                throw new UnsupportedOperationException("This version of FreePBX does not supported yet");
        }
    }

    public enum FreePBX{
        V12, V13
    }

}
