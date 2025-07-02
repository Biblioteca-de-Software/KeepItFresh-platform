package com.go4u.keepitfreshplatform.iam.interfaces.rest.transform;
import com.go4u.keepitfreshplatform.iam.domain.model.aggregates.User;
import com.go4u.keepitfreshplatform.iam.interfaces.rest.resources.UserResource;
public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity) {
        return new UserResource(
                entity.getId(),
                entity.getUsername(),
                RoleStringListFromEntityListAssembler.toResourceListFromEntitySet(entity.getRoles()));
    }
}
