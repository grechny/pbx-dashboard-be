package by.sysadmins.dashboard.entities.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import by.sysadmins.dashboard.entities.Dbms;

@Repository
public interface DbmsRepository extends CrudRepository<Dbms, Integer> {

}
