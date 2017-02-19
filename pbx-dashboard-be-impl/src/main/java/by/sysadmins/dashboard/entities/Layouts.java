package by.sysadmins.dashboard.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "layouts")
public class Layouts implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_layout")
    private Integer idLayout;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private Users users;

    @Column(name = "layout")
    private String layout;

    public Layouts() {
    }

    public Layouts(Users user, String layout) {
        setUsers(user);
        setLayout(layout);
    }

    public Integer getIdLayout() {
        return idLayout;
    }

    public void setIdLayout(Integer idLayout) {
        this.idLayout = idLayout;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Layouts layouts = (Layouts) o;

        if (!idLayout.equals(layouts.idLayout)) return false;
        if (!users.equals(layouts.users)) return false;
        return layout != null ? layout.equals(layouts.layout) : layouts.layout == null;

    }

    @Override
    public int hashCode() {
        int result = idLayout.hashCode();
        result = 31 * result + users.hashCode();
        result = 31 * result + (layout != null ? layout.hashCode() : 0);
        return result;
    }
}
