package by.sysadmins.dashboard.entities.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import by.sysadmins.dashboard.entities.Layout;

@Repository
public interface LayoutsRepository extends CrudRepository<Layout, Integer> {

    @Query("select l.layout from Layout l inner join l.user u where u.username = ?1")
    String getLayoutByUsername(String username);

}
