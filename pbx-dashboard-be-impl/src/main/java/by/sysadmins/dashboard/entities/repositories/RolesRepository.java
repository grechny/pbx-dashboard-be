package by.sysadmins.dashboard.entities.repositories;

import by.sysadmins.dashboard.entities.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends CrudRepository<Roles, Integer> {

}
