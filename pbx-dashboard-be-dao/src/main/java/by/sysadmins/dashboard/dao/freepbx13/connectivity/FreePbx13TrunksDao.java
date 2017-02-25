package by.sysadmins.dashboard.dao.freepbx13.connectivity;

import org.apache.tomcat.jdbc.pool.DataSource;

import by.sysadmins.dashboard.dao.freepbx.connectivity.TrunksDao;

public class FreePbx13TrunksDao extends TrunksDao {

    public FreePbx13TrunksDao(DataSource dataSource) {
        super(dataSource);
    }

}
