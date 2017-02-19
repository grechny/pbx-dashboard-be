package by.sysadmins.dashboard.entities.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import by.sysadmins.dashboard.entities.Layouts;
import by.sysadmins.dashboard.entities.Users;

@Repository
public interface LayoutsRepository extends CrudRepository<Layouts, Integer> {

    @Query("select l.layout from Layouts l inner join l.users u where u.username = ?1")
    String getLayoutByUsername(String username);

    Layouts findByUsers(Users user);
}
