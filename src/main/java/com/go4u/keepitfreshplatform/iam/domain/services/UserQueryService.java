package com.go4u.keepitfreshplatform.iam.domain.services;
import com.go4u.keepitfreshplatform.iam.domain.model.aggregates.User;
import com.go4u.keepitfreshplatform.iam.domain.model.queries.GetAllUsersQueries;
import com.go4u.keepitfreshplatform.iam.domain.model.queries.GetUserByIdQueries;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {

    List<User> handle(GetAllUsersQueries query);

    Optional<User> handle(GetUserByIdQueries query);
}
