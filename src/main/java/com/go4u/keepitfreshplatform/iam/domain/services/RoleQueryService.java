package com.go4u.keepitfreshplatform.iam.domain.services;
import com.go4u.keepitfreshplatform.iam.domain.model.entities.Role;
import com.go4u.keepitfreshplatform.iam.domain.model.queries.GetAllRolesQuery;
import com.go4u.keepitfreshplatform.iam.domain.model.queries.GetRoleByNameQueries;

import java.util.List;
import java.util.Optional;
public interface RoleQueryService {
    List <Role> handle(GetAllRolesQuery query);
    Optional<Role> handle(GetRoleByNameQueries query);

}
