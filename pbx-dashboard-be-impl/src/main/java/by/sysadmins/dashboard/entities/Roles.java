package by.sysadmins.dashboard.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "roles")
public class Roles implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_role")
    private Integer idRole;

    @Column(name = "role")
    private String role;

    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, targetEntity = UserRoles.class, mappedBy = "roles")
    private List<UserRoles> userRoles;

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

    public List<UserRoles> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRoles> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roles roles = (Roles) o;

        if (!idRole.equals(roles.idRole)) return false;
        return role.equals(roles.role);

    }

    @Override
    public int hashCode() {
        int result = idRole.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }
}
