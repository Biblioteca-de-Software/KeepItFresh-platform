package com.go4u.keepitfreshplatform.profiles.interfaces.rest.transform;

import com.go4u.keepitfreshplatform.profiles.domain.model.commands.CreateProfileCommand;
import com.go4u.keepitfreshplatform.profiles.interfaces.rest.resources.CreateProfileResource;

/**
 * Assembler to convert a CreateProfileResource to a CreateProfileCommand.
 */
public class CreateProfileCommandFromResourceAssembler {

    /**
     * Converts a CreateProfileResource to a CreateProfileCommand.
     * @param resource The {@link CreateProfileResource} resource to convert.
     * @return The {@link CreateProfileCommand} command.
     */
    public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource) {
        return new CreateProfileCommand(
                resource.firstName(),
                resource.lastName(),
                resource.email(),
                resource.birthDate(),
                resource.phoneNumber(),
                resource.userId()
        );
    }
}
