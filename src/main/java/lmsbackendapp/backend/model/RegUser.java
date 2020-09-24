package lmsbackendapp.backend.model;

import com.fasterxml.jackson.annotation.JsonView;
import lmsbackendapp.backend.utils.ViewUtils;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RegUser {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length=64, nullable = false, unique = true)
    private String username;

    @Column(length=64, nullable = false)
    private String password;

    @Column(length=64, nullable = false)
    private String email;

    @JsonView(ViewUtils.ShowUserPermssion.class)
    @OneToMany(mappedBy = "regUser", cascade = CascadeType.ALL)
    private Set<UserPermission> userPermission;

    @JsonView(ViewUtils.ShowAdminStaff.class)
    @OneToMany(mappedBy="regUser")
    private Set<AdminStaff> adminStaff;

    public RegUser() {}

    public RegUser(Long id, String username, String password, String email,
                                Set<UserPermission> userPermission, Set<AdminStaff> adminStaff) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userPermission = userPermission;
        this.adminStaff = adminStaff;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<UserPermission> getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(Set<UserPermission> userPermission) {
        this.userPermission = userPermission;
    }

    public Set<AdminStaff> getAdminStaff() {
        return adminStaff;
    }

    public void setAdminStaff(Set<AdminStaff> adminStaff) {
        this.adminStaff = adminStaff;
    }
}
