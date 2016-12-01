package by.sysadmins.dashboard.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "companies")
public class Companies implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "id_company")
    private Integer idCompany;

    @Column(name = "company_name")
    private String companyName;

    @OneToMany(cascade=CascadeType.ALL, targetEntity = Users.class, mappedBy = "companies")
    private Collection users;

    @OneToMany(cascade=CascadeType.ALL, targetEntity = CompanyCredentials.class, mappedBy = "companies")
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

        Companies companies = (Companies) o;

        if (!idCompany.equals(companies.idCompany)) return false;
        return companyName.equals(companies.companyName);

    }

    @Override
    public int hashCode() {
        int result = idCompany.hashCode();
        result = 31 * result + companyName.hashCode();
        return result;
    }
}
