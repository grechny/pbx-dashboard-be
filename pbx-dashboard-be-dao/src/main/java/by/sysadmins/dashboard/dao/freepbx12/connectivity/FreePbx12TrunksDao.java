package by.sysadmins.dashboard.dao.freepbx12.connectivity;

import org.apache.tomcat.jdbc.pool.DataSource;

import java.util.List;

import by.sysadmins.dashboard.dao.freepbx.connectivity.TrunksDao;

public class FreePbx12TrunksDao extends TrunksDao {

    public FreePbx12TrunksDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void create(Object entity) {
        //todo implement method
    }

    @Override
    public void update(Object entity) {
        //todo implement method
    }

    @Override
    public List findAll() {
        //todo implement method
        return null;
    }

    @Override
    public void delete(Object entity) {
        //todo implement method
    }
}
