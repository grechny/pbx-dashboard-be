package by.sysadmins.dashboard.entities.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import by.sysadmins.dashboard.entities.Users;

/**
 * Created by kosyak on 07.01.2016.
 * Repository for `users` entities
 */
@Repository
public interface UsersRepository extends CrudRepository<Users, Integer> {

    Users findByUsername(String username);

}
