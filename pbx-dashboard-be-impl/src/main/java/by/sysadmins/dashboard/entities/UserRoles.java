package by.sysadmins.dashboard.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_roles")
public class UserRoles implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_user_role")
    private Integer idUserRole;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private Users users;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_role")
    private Roles roles;

    public Integer getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(Integer idUserRole) {
        this.idUserRole = idUserRole;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRoles userRoles = (UserRoles) o;

        if (!idUserRole.equals(userRoles.idUserRole)) return false;
        if (!users.equals(userRoles.users)) return false;
        if (!roles.equals(userRoles.roles)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUserRole.hashCode();
        result = 31 * result + users.hashCode();
        result = 31 * result + roles.hashCode();
        return result;
    }
}
