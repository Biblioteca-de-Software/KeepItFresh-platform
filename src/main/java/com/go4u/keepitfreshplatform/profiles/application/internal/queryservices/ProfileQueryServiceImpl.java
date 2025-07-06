package com.go4u.keepitfreshplatform.profiles.application.internal.queryservices;

import com.go4u.keepitfreshplatform.profiles.domain.model.aggregates.Profile;
import com.go4u.keepitfreshplatform.profiles.domain.model.queries.GetAllProfilesQuery;
import com.go4u.keepitfreshplatform.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.go4u.keepitfreshplatform.profiles.domain.model.queries.GetProfileByIdQuery;
import com.go4u.keepitfreshplatform.profiles.domain.model.valueobjects.EmailAddress;
import com.go4u.keepitfreshplatform.profiles.domain.services.ProfileQueryService;
import com.go4u.keepitfreshplatform.profiles.infrastructure.persistence.jpa.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Profile Query Service Implementation
 */
@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {

    private final ProfileRepository profileRepository;

    public ProfileQueryServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<Profile> handle(GetProfileByIdQuery query) {
        return profileRepository.findById(query.profileId());
    }

    @Override
    public Optional<Profile> handle(GetProfileByEmailQuery query) {
        return profileRepository.findByEmailAddress(query.emailAddress());
    }

    @Override
    public List<Profile> handle(GetAllProfilesQuery query) {
        return profileRepository.findAll();
    }
}
