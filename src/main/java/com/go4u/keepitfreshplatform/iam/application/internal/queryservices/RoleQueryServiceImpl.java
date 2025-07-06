package com.go4u.keepitfreshplatform.iam.application.internal.queryservices;
import com.go4u.keepitfreshplatform.iam.domain.model.entities.Role;
import com.go4u.keepitfreshplatform.iam.domain.model.queries.GetRoleByNameQuery;
import com.go4u.keepitfreshplatform.iam.domain.model.queries.GetAllRolesQuery;
import com.go4u.keepitfreshplatform.iam.domain.services.RoleQueryService;
import com.go4u.keepitfreshplatform.iam.infraestructure.persistence.jpa.repository.RoleRepository;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * RoleQueryServiceImpl class
 * This class is used to handle the role queries
 */
@Service
public class RoleQueryServiceImpl implements RoleQueryService {
    private final RoleRepository roleRepository;


    public RoleQueryServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public List<Role> handle(GetAllRolesQuery query) {
        return roleRepository.findAll();
    }


    @Override
    public Optional<Role> handle(GetRoleByNameQuery query) {
        return roleRepository.findByName(query.roleName());
    }
}