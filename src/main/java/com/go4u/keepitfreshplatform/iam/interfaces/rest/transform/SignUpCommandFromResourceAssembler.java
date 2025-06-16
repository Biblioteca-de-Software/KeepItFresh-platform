package com.go4u.keepitfreshplatform.iam.interfaces.rest.transform;
import com.go4u.keepitfreshplatform.iam.domain.model.commands.SignUpCommand;
import com.go4u.keepitfreshplatform.iam.interfaces.rest.resources.SignUpResource;
public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        var roles = RoleListFromStringAssembler.toRoleListFromStringList(resource.roles());
        return new SignUpCommand(resource.username(), resource.password(), roles);
    }
}
