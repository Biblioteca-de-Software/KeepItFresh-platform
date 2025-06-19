package com.go4u.keepitfreshplatform.iam.interfaces.rest.transform;
import com.go4u.keepitfreshplatform.iam.domain.model.entities.Role;
import com.go4u.keepitfreshplatform.iam.interfaces.rest.resources.RoleResource;
public class RoleResourceFromEntityAssembler {
 public static RoleResource toResourceFromEntity(Role entity) {
    return new RoleResource(
            entity.getId(),
            entity.getStringName());
}
}
