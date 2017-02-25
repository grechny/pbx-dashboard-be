package by.sysadmins.dashboard.dao.freepbx12.connectivity;

import org.apache.tomcat.jdbc.pool.DataSource;

import by.sysadmins.dashboard.dao.freepbx.connectivity.TrunksDao;

public class FreePbx12TrunksDao extends TrunksDao {

    public FreePbx12TrunksDao(DataSource dataSource) {
        super(dataSource);
    }

}
