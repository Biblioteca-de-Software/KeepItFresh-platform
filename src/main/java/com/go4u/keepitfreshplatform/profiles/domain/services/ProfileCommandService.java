package com.go4u.keepitfreshplatform.profiles.domain.services;
import com.go4u.keepitfreshplatform.profiles.domain.model.aggregates.Profile;
import com.go4u.keepitfreshplatform.profiles.domain.model.commands.CreateProfileCommand;
import java.util.Optional;
public interface ProfileCommandService {
    Optional<Profile> handle(CreateProfileCommand command);

}
