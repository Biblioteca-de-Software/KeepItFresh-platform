package com.go4u.keepitfreshplatform.profiles.domain.services;
import com.go4u.keepitfreshplatform.profiles.domain.model.queries.GetAllProfilesQuery;
import com.go4u.keepitfreshplatform.profiles.domain.model.queries.GetProfileByIdQuery;
import com.go4u.keepitfreshplatform.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.go4u.keepitfreshplatform.profiles.domain.model.aggregates.Profile;
import java.util.List;
import java.util.Optional;

public interface ProfileQueryService{
    Optional<Profile> handle(GetProfileByIdQuery query);
    Optional<Profile> handle(GetProfileByEmailQuery query);
    List<Profile> handle(GetAllProfilesQuery query);

}
