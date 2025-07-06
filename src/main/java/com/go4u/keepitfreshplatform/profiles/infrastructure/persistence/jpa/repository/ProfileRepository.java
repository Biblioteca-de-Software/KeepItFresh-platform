package com.go4u.keepitfreshplatform.profiles.infrastructure.persistence.jpa.repository;

import com.go4u.keepitfreshplatform.profiles.domain.model.aggregates.Profile;
import com.go4u.keepitfreshplatform.profiles.domain.model.valueobjects.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {


    Optional<Profile> findByEmailAddress(EmailAddress emailAddress);


    Optional<Profile> findByUserId(Long userId);


    boolean existsByEmailAddress(EmailAddress emailAddress);


    boolean existsByUserId(Long userId);
}
