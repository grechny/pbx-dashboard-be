package by.sysadmins.dashboard.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "company_credentials")
public class CompanyCredentials implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_company_credentials")
    private Integer idCompanyCredentials;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_company")
    private Company company;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_dbms")
    private Dbms dbms;

    @Column(name = "db_address")
    private String dbAddress;

    @Column(name = "db_port")
    private Integer dbPort;

    @Column(name = "db_name")
    private String dbName;

    @Column(name = "db_username")
    private String dbUsername;

    @Column(name = "db_password")
    private String dbPassword;

    public Integer getIdCompanyCredentials() {
        return idCompanyCredentials;
    }

    public void setIdCompanyCredentials(Integer idCompanyCredentials) {
        this.idCompanyCredentials = idCompanyCredentials;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompanyCredentials that = (CompanyCredentials) o;

        if (!idCompanyCredentials.equals(that.idCompanyCredentials)) return false;
        if (!company.equals(that.company)) return false;
        if (!dbms.equals(that.dbms)) return false;
        if (!dbAddress.equals(that.dbAddress)) return false;
        if (!dbPort.equals(that.dbPort)) return false;
        if (!dbName.equals(that.dbName)) return false;
        if (!dbUsername.equals(that.dbUsername)) return false;
        return dbPassword.equals(that.dbPassword);

    }

    @Override
    public int hashCode() {
        int result = idCompanyCredentials.hashCode();
        result = 31 * result + company.hashCode();
        result = 31 * result + dbms.hashCode();
        result = 31 * result + dbAddress.hashCode();
        result = 31 * result + dbPort.hashCode();
        result = 31 * result + dbName.hashCode();
        result = 31 * result + dbUsername.hashCode();
        result = 31 * result + dbPassword.hashCode();
        return result;
    }
}
