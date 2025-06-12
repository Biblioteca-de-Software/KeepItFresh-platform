package com.go4u.keepitfreshplatform.iam.domain.model.aggregates;
import com.go4u.keepitfreshplatform.iam.domain.model.Entity.Role;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import jakarta.persistence.*;

import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class User extends AbstractAggregateRoot<User> {
@Id

@NotBlank
@Size(max = 60)
private String username;

@NotBlank
@Size(max = 120)
private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="user_roles",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id")
    )
    private Set<Role> roles;
    public User() {
        this.roles = new HashSet<>();
    }
    private User(String username, String password) {
        this();
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, List<Role> roles) {
        this(username, password);
        addRoles(roles);
    }

    public User addRoles(Role role) {
        this.roles.add(role);
        return this;
    }

    public User addRoles(List<Role> roles) {
        var validatedRolesSet = Role.validateRoleSet(roles);
        this.roles.addAll(roles);
        return this;
    }
}
