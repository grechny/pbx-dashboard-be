package by.sysadmins.dashboard.entities.repositories;

import by.sysadmins.dashboard.entities.CompanyCredentials;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyCredentialsRepository extends CrudRepository<CompanyCredentials, Integer> {

    CompanyCredentials getByCompanies_companyNameAndDbName(String companyName, String dbName);

}
