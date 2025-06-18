package com.go4u.keepitfreshplatform.iam.application.internal.commandservices;

import com.go4u.keepitfreshplatform.iam.application.internal.outboundservices.hashing.HashingService;
import com.go4u.keepitfreshplatform.iam.application.internal.outboundservices.tokens.TokenService;
import com.go4u.keepitfreshplatform.iam.domain.model.aggregates.User;
import com.go4u.keepitfreshplatform.iam.domain.model.commands.SignInCommand;
import com.go4u.keepitfreshplatform.iam.domain.model.commands.SignUpCommand;
import com.go4u.keepitfreshplatform.iam.domain.services.UserCommandService;
import com.go4u.keepitfreshplatform.iam.infraestructure.persistence.jpa.repository.RoleRepository;
import com.go4u.keepitfreshplatform.iam.infraestructure.persistence.jpa.repository.UserRepository;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final HashingService hashingService;
    private final TokenService tokenService;
    private final RoleRepository roleRepository;

    /**
     * Constructor
     * @param userRepository {@link UserRepository} instance
     * @param hashingService {@link HashingService} instance
     * @param tokenService {@link TokenService} instance
     * @param roleRepository {@link RoleRepository} instance
     */
    public UserCommandServiceImpl(UserRepository userRepository, HashingService hashingService, TokenService tokenService, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.hashingService = hashingService;
        this.tokenService = tokenService;
        this.roleRepository = roleRepository;
    }

    // inherited javadoc
    @Override
    public Optional<User> handle(SignUpCommand command) {
        if (userRepository.existsByUsername(command.username()))
            throw new RuntimeException("Username already exists");
        var roles = command.roles().stream().map(role -> roleRepository.findByName(role.getName()).orElseThrow(() -> new RuntimeException("Role not found"))).toList();
        var user = new User(command.username(), hashingService.encode(command.password()), roles);
        userRepository.save(user);
        return userRepository.findByUsername(command.username());
    }

    // inherited javadoc
    @Override
    public Optional<ImmutablePair<User, String>> handle(SignInCommand command) {
        var user = userRepository.findByUsername(command.username());
        if (user.isEmpty()) throw new RuntimeException("User not found");
        var existingUser = user.get();
        if(!hashingService.matches(command.password(), existingUser.getPassword())) throw new RuntimeException("Invalid password");
        var token = tokenService.generateToken(existingUser.getUsername());
        return Optional.of(ImmutablePair.of(existingUser, token));
    }
}