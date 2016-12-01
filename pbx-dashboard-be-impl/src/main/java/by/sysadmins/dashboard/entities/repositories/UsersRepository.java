package by.sysadmins.dashboard.entities.repositories;

import by.sysadmins.dashboard.entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kosyak on 07.01.2016.
 * Repository for `users` entities
 */
@Repository
public interface UsersRepository extends CrudRepository<Users, Integer> {

    Users findByUsername (String username);

}
