package com.go4u.keepitfreshplatform.iam.application.internal.queryservices;

import com.go4u.keepitfreshplatform.iam.domain.model.entities.Role;
import com.go4u.keepitfreshplatform.iam.domain.model.queries.GetAllRolesQuery;
import com.go4u.keepitfreshplatform.iam.domain.model.queries.GetRoleByNameQuery;
import com.go4u.keepitfreshplatform.iam.domain.services.RoleQueryService;
import com.go4u.keepitfreshplatform.iam.infraestructure.persistence.jpa.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleQueryServiceImpl implements RoleQueryService {
    private final RoleRepository roleRepository;

    /**
     * Constructor
     * @param roleRepository the {@link RoleRepository} instance
     */
    public RoleQueryServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * Handles the {@link GetAllRolesQuery} query.
     * @param query the {@link GetAllRolesQuery} instance
     * @return the list of {@link Role} instances
     */
    @Override
    public List<Role> handle(GetAllRolesQuery query) {
        return roleRepository.findAll();
    }

    /**
     * Handles the {@link GetRoleByNameQuery} query.
     * @param query the {@link GetRoleByNameQuery} instance
     * @return the {@link Role} instance if found
     */
    @Override
    public Optional<Role> handle(GetRoleByNameQuery query) {
        return roleRepository.findByName(query.name());
    }
}