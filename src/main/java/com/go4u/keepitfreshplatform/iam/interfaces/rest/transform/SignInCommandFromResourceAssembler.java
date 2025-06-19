package com.go4u.keepitfreshplatform.iam.interfaces.rest.transform;
import com.go4u.keepitfreshplatform.iam.domain.model.commands.SignInCommand;
import com.go4u.keepitfreshplatform.iam.interfaces.rest.resources.SignInResource;
public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource resource) {
        return new SignInCommand(
                resource.username(),
                resource.password());
    }
}
