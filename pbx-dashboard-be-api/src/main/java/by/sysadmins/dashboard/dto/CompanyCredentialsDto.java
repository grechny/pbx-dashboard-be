package by.sysadmins.dashboard.dto;

import by.sysadmins.dashboard.dto.enums.Dbms;
import by.sysadmins.dashboard.dto.enums.FreePbx;

public class CompanyCredentialsDto {

    private String companyName;
    private FreePbx pbxVersion;
    private Dbms dbms;
    private String dbAddress;
    private Integer dbPort;
    private String dbName;
    private String dbUsername;
    private String dbPassword;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public FreePbx getPbxVersion() {
        return pbxVersion;
    }

    public void setPbxVersion(FreePbx pbxVersion) {
        this.pbxVersion = pbxVersion;
    }

    public Dbms getDbms() {
        return dbms;
    }

    public void setDbms(Dbms dbms) {
        this.dbms = dbms;
    }

    public String getDbAddress() {
        return dbAddress;
    }

    public void setDbAddress(String dbAddress) {
        this.dbAddress = dbAddress;
    }

    public Integer getDbPort() {
        return dbPort;
    }

    public void setDbPort(Integer dbPort) {
        this.dbPort = dbPort;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }
}
