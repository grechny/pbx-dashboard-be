package by.sysadmins.dashboard.dao;

import java.util.List;

public interface GenericDaoOperations<E> {
    void create(E entity);

    void update(E entity);

    List<E> findAll();

    void delete(E entity);
}
