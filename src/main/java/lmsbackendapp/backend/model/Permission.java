package lmsbackendapp.backend.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

//    @JsonView()
    @OneToMany(mappedBy = "permission")
    private Set<UserPermission> userPermission;

    public Permission() {};

    public Permission(Long id, String name, Set<UserPermission> userPermission) {
        super();
        this.id = id;
        this.name = name;
        this.userPermission = userPermission;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserPermission> getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(Set<UserPermission> userPermission) {
        this.userPermission = userPermission;
    }
}
