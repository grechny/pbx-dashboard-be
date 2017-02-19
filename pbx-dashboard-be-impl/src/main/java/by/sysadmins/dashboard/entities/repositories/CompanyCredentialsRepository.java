package by.sysadmins.dashboard.entities.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import by.sysadmins.dashboard.entities.CompanyCredentials;

@Repository
public interface CompanyCredentialsRepository extends CrudRepository<CompanyCredentials, Integer> {

    CompanyCredentials getByCompanies_companyNameAndDbName(String companyName, String dbName);

}
