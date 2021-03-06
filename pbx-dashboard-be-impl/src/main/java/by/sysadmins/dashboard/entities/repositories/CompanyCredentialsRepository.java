package by.sysadmins.dashboard.entities.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import by.sysadmins.dashboard.entities.CompanyCredentials;

@Repository
public interface CompanyCredentialsRepository extends CrudRepository<CompanyCredentials, Integer> {

    List<CompanyCredentials> getByCompany_companyName(String companyName);

    CompanyCredentials getByCompany_companyNameAndDbName(String companyName, String dbName);

}
