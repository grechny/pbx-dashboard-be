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
@Table(name = "user_roles")
public class UserRole implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_user_role")
    private Integer idUserRole;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_role")
    private Role role;

    public Integer getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(Integer idUserRole) {
        this.idUserRole = idUserRole;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (!idUserRole.equals(userRole.idUserRole)) return false;
        if (!user.equals(userRole.user)) return false;
        if (!role.equals(userRole.role)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUserRole.hashCode();
        result = 31 * result + user.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }
}
