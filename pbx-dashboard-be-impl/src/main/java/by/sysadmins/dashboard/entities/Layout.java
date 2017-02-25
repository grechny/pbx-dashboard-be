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
public class Layout implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_layout")
    private Integer idLayout;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User user;

    @Column(name = "layout")
    private String layout;

    public Layout() {
    }

    public Layout(User user, String layout) {
        setUser(user);
        setLayout(layout);
    }

    public Integer getIdLayout() {
        return idLayout;
    }

    public void setIdLayout(Integer idLayout) {
        this.idLayout = idLayout;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

        Layout layout = (Layout) o;

        if (!idLayout.equals(layout.idLayout)) return false;
        if (!user.equals(layout.user)) return false;
        return this.layout != null ? this.layout.equals(layout.layout) : layout.layout == null;

    }

    @Override
    public int hashCode() {
        int result = idLayout.hashCode();
        result = 31 * result + user.hashCode();
        result = 31 * result + (layout != null ? layout.hashCode() : 0);
        return result;
    }
}
