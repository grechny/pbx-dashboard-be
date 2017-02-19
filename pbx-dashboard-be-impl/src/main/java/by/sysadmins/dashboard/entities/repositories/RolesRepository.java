package by.sysadmins.dashboard.entities.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import by.sysadmins.dashboard.entities.Roles;

@Repository
public interface RolesRepository extends CrudRepository<Roles, Integer> {

}
