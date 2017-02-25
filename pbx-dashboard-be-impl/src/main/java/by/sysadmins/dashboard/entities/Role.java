package by.sysadmins.dashboard.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_role")
    private Integer idRole;

    @Column(name = "role")
    private String role;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = UserRole.class, mappedBy = "role")
    private List<UserRole> userRoles;

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (!idRole.equals(role.idRole)) return false;
        return this.role.equals(role.role);

    }

    @Override
    public int hashCode() {
        int result = idRole.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }
}
