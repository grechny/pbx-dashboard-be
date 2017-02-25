package by.sysadmins.dashboard.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "companies")
public class Company implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_company")
    private Integer idCompany;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "pbx_version")
    private String pbxVersion;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = User.class, mappedBy = "company")
    private Collection users;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = CompanyCredentials.class, mappedBy = "company")
    private Collection companyCredentials;

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPbxVersion() {
        return pbxVersion;
    }

    public void setPbxVersion(String pbxVersion) {
        this.pbxVersion = pbxVersion;
    }

    public Collection getUsers() {
        return users;
    }

    public void setUsers(Collection users) {
        this.users = users;
    }

    public Collection getCompanyCredentials() {
        return companyCredentials;
    }

    public void setCompanyCredentials(Collection companyCredentials) {
        this.companyCredentials = companyCredentials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (!idCompany.equals(company.idCompany)) return false;
        return companyName.equals(company.companyName);

    }

    @Override
    public int hashCode() {
        int result = idCompany.hashCode();
        result = 31 * result + companyName.hashCode();
        return result;
    }
}
