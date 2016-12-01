package by.sysadmins.dashboard.entities.repositories;

import by.sysadmins.dashboard.entities.Dbms;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbmsRepository extends CrudRepository<Dbms, Integer> {

}
