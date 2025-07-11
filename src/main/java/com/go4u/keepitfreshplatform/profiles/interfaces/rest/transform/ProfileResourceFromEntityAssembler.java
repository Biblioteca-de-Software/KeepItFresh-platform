package com.go4u.keepitfreshplatform.profiles.interfaces.rest.transform;

import com.go4u.keepitfreshplatform.profiles.domain.model.aggregates.Profile;
import com.go4u.keepitfreshplatform.profiles.interfaces.rest.resources.ProfileResource;

/**
 * Assembler to convert a Profile entity to a ProfileResource.
 */
public class ProfileResourceFromEntityAssembler {

    /**
     * Converts a Profile entity to a ProfileResource.
     * @param entity The {@link Profile} entity to convert.
     * @return The {@link ProfileResource} resource.
     */
    public static ProfileResource toResourceFromEntity(Profile entity) {
        return new ProfileResource(
                entity.getId(),
                entity.getFullName(),
                entity.getEmailAddress(),
                entity.getPhoneNumber(),
                entity.getBirthDate(),
                entity.getUserId()
        );
    }
}
