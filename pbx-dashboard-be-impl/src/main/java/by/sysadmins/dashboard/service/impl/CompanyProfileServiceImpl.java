package by.sysadmins.dashboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import by.sysadmins.dashboard.dto.CompanyCredentialsDto;
import by.sysadmins.dashboard.dto.enums.Dbms;
import by.sysadmins.dashboard.dto.enums.FreePbx;
import by.sysadmins.dashboard.entities.CompanyCredentials;
import by.sysadmins.dashboard.entities.repositories.CompanyCredentialsRepository;
import by.sysadmins.dashboard.services.CompanyProfileService;

@Component
public class CompanyProfileServiceImpl implements CompanyProfileService {

    private final CompanyCredentialsRepository companyCredentialsRepository;

    @Autowired
    public CompanyProfileServiceImpl(CompanyCredentialsRepository companyCredentialsRepository) {
        this.companyCredentialsRepository = companyCredentialsRepository;
    }

    @Override
    public List<CompanyCredentialsDto> getCompanyCredentials(String companyName) {
        List<CompanyCredentials> companyCredentialsList = companyCredentialsRepository.getByCompany_companyName(companyName);
        List<CompanyCredentialsDto> companyCredentialsDtoList = new ArrayList<>();
        for (CompanyCredentials companyCredentials : companyCredentialsList) {
            CompanyCredentialsDto companyCredentialsDto = new CompanyCredentialsDto();
            convertCompanyCredentialsToDTO(companyCredentials, companyCredentialsDto);
            companyCredentialsDtoList.add(companyCredentialsDto);
        }

        return companyCredentialsDtoList;
    }

    @Override
    public CompanyCredentialsDto getCompanyCredentials(String companyName, String dbName) {
        CompanyCredentials companyCredentials = companyCredentialsRepository.getByCompany_companyNameAndDbName(companyName, dbName);
        CompanyCredentialsDto companyCredentialsDto = new CompanyCredentialsDto();
        convertCompanyCredentialsToDTO(companyCredentials, companyCredentialsDto);
        return companyCredentialsDto;
    }

    private void convertCompanyCredentialsToDTO(CompanyCredentials companyCredentials,
                                                CompanyCredentialsDto companyCredentialsDto) {
        companyCredentialsDto.setCompanyName(companyCredentials.getCompany().getCompanyName());
        companyCredentialsDto.setPbxVersion(FreePbx.valueOf(companyCredentials.getCompany().getPbxVersion()));
        companyCredentialsDto.setDbms(Dbms.valueOf(companyCredentials.getDbms().getDbms()));
        companyCredentialsDto.setDbName(companyCredentials.getDbName());
        companyCredentialsDto.setDbAddress(companyCredentials.getDbAddress());
        companyCredentialsDto.setDbPort(companyCredentials.getDbPort());
        companyCredentialsDto.setDbUsername(companyCredentials.getDbUsername());
        companyCredentialsDto.setDbPassword(companyCredentials.getDbPassword());
    }
}
