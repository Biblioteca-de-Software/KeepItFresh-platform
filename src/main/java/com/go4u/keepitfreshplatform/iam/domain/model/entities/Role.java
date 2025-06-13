package com.go4u.keepitfreshplatform.iam.domain.model.entities;
import com.go4u.keepitfreshplatform.iam.domain.model.valueobjects.Roles;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class Role {
@Id
private Long id;


@Enumerated(EnumType.STRING)
@Column(length = 20)
private Roles name;

public Role(Roles name) {
        this.name = name;
    }
    public String getStringName() {
        return name.name();
    }

    public static Role getDefaultRole_() {
        return new Role(Roles.ROLE_OWNER);
    }
    public static Role toRoleFromName(String name) {
        return new Role(Roles.valueOf(name));
    }

    public static List<Role> validateRoleSet(List<Role> roles) {
        if (roles == null || roles.isEmpty()) {
            return List.of(getDefaultRole_());
        }
        return roles;
    }
}
