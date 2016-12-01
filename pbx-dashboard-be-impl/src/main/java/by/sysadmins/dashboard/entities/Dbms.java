package by.sysadmins.dashboard.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "dbms")
public class Dbms implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "id_dbms")
    private Integer idDbms;

    @Column(name = "dbms")
    private String dbms;

    @OneToMany(cascade=CascadeType.ALL, targetEntity = CompanyCredentials.class, mappedBy = "dbms")
    private Collection companyCredentials;

    public Integer getIdDbms() {
        return idDbms;
    }

    public void setIdDbms(Integer idDbms) {
        this.idDbms = idDbms;
    }

    public String getDbms() {
        return dbms;
    }

    public void setDbms(String dbms) {
        this.dbms = dbms;
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

        Dbms dbms1 = (Dbms) o;

        if (!idDbms.equals(dbms1.idDbms)) return false;
        if (!dbms.equals(dbms1.dbms)) return false;
        return companyCredentials.equals(dbms1.companyCredentials);

    }

    @Override
    public int hashCode() {
        int result = idDbms.hashCode();
        result = 31 * result + dbms.hashCode();
        result = 31 * result + companyCredentials.hashCode();
        return result;
    }
}
