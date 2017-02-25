package by.sysadmins.dashboard.entities.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import by.sysadmins.dashboard.entities.Company;

@Repository
public interface CompaniesRepository extends CrudRepository<Company, Integer> {

    @Query("select c.companyName from Company c inner join c.users u where u.username = ?1")
    String getCompanyNameByUsername(String username);

}
