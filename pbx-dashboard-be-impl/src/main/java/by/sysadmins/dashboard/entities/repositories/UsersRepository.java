package by.sysadmins.dashboard.entities.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import by.sysadmins.dashboard.entities.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}
