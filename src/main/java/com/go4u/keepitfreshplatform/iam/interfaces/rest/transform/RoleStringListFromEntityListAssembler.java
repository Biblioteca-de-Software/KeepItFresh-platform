package com.go4u.keepitfreshplatform.iam.interfaces.rest.transform;

import com.go4u.keepitfreshplatform.iam.domain.model.entities.Role;

import java.util.List;
import java.util.Set;
public class RoleStringListFromEntityListAssembler {
    public static List<String> toResourceListFromEntitySet(Set<Role> entity) {
        return entity.stream()
                .map(Role::getStringName)
                .toList();
    }
}


