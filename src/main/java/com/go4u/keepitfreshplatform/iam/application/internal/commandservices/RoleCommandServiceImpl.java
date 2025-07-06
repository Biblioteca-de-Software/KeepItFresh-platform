package com.go4u.keepitfreshplatform.iam.application.internal.commandservices;
import com.go4u.keepitfreshplatform.iam.domain.model.commands.SeedRolesCommand;
import com.go4u.keepitfreshplatform.iam.domain.model.entities.Role;
import com.go4u.keepitfreshplatform.iam.domain.model.valueobjects.Roles;
import com.go4u.keepitfreshplatform.iam.domain.services.RoleCommandService;
import com.go4u.keepitfreshplatform.iam.infraestructure.persistence.jpa.repository.RoleRepository;

import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class RoleCommandServiceImpl implements RoleCommandService {
    private final RoleRepository roleRepository;

    public RoleCommandServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // inherit javadoc
    @Override
    public void handle(SeedRolesCommand command) {
        Arrays.stream(Roles.values()).forEach(role -> {
            if (!roleRepository.existsByName(role)) {
                roleRepository.save(new Role(Roles.valueOf(role.name())));
            }
        });
    }
}
