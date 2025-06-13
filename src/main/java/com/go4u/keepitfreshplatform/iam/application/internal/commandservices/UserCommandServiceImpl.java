package com.go4u.keepitfreshplatform.iam.application.internal.commandservices;

import com.go4u.keepitfreshplatform.iam.domain.model.aggregates.User;
import com.go4u.keepitfreshplatform.iam.domain.model.commands.SignUpCommand;
import com.go4u.keepitfreshplatform.iam.domain.model.commands.SignInCommand;
import com.go4u.keepitfreshplatform.iam.domain.services.UserCommandsService;
import com.go4u.keepitfreshplatform.iam.infraestructure.persistence.jpa.repository.RoleRepository;
import com.go4u.keepitfreshplatform.iam.infraestructure.persistence.jpa.repository.UserRepository;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public  class UserCommandServiceImpl implements UserCommandsService {
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public UserCommandServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    /**
     * @param command
     * @return
     */
    @Override
    public Optional<ImmutablePair<User, String>> handle(SignInCommand command) {
        return Optional.empty();
    }

    /**
     * @param command
     * @return
     */
    @Override
    public Optional<User> handle(SignUpCommand command) {
        return Optional.empty();
    }
}
