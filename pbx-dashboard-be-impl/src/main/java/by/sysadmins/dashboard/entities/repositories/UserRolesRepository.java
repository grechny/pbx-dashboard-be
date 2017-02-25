package by.sysadmins.dashboard.entities.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import by.sysadmins.dashboard.entities.UserRole;

@Repository
public interface UserRolesRepository extends CrudRepository<UserRole, Integer> {

}
