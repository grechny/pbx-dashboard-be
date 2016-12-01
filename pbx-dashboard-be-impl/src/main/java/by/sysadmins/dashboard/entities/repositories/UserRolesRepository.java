package by.sysadmins.dashboard.entities.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import by.sysadmins.dashboard.entities.UserRoles;

@Repository
public interface UserRolesRepository extends CrudRepository<UserRoles, Integer> {

}
