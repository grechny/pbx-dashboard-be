package by.sysadmins.dashboard.services;

import java.util.List;

import by.sysadmins.dashboard.dto.CompanyCredentialsDto;

public interface CompanyProfileService {

    List<CompanyCredentialsDto> getCompanyCredentials(String companyName);

    CompanyCredentialsDto getCompanyCredentials(String companyName, String dbName);

}
