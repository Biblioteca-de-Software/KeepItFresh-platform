package com.go4u.keepitfreshplatform.profiles.application.acl;

import com.go4u.keepitfreshplatform.profiles.domain.model.commands.CreateProfileCommand;
import com.go4u.keepitfreshplatform.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.go4u.keepitfreshplatform.profiles.domain.model.valueobjects.EmailAddress;
import com.go4u.keepitfreshplatform.profiles.domain.services.ProfileCommandService;
import com.go4u.keepitfreshplatform.profiles.domain.services.ProfileQueryService;
import com.go4u.keepitfreshplatform.profiles.interfaces.acl.ProfilesContextFacade;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ProfilesContextFacadeImpl implements ProfilesContextFacade {

    private final ProfileCommandService profileCommandService;
    private final ProfileQueryService profileQueryService;

    public ProfilesContextFacadeImpl(ProfileCommandService profileCommandService, ProfileQueryService profileQueryService) {
        this.profileCommandService = profileCommandService;
        this.profileQueryService = profileQueryService;
    }

    @Override
    public Long createProfile(String firstName, String lastName, String email,
                              LocalDate birthDate, String phoneNumber, Long userId) {

        var command = new CreateProfileCommand(firstName, lastName, email, birthDate, phoneNumber, userId);
        var profile = profileCommandService.handle(command);

        return profile.map(p -> p.getId()).orElse(0L);
    }

    @Override
    public Long fetchProfileIdByEmail(String email) {
        var query = new GetProfileByEmailQuery(new EmailAddress(email));
        var profile = profileQueryService.handle(query);

        return profile.map(p -> p.getId()).orElse(0L);
    }
}
