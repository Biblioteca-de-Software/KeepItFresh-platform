package com.go4u.keepitfreshplatform.iam.application.acl;

import com.go4u.keepitfreshplatform.iam.domain.model.commands.SignUpCommand;
import com.go4u.keepitfreshplatform.iam.domain.model.entities.Role;
import com.go4u.keepitfreshplatform.iam.domain.model.queries.GetUserByIdQuery;
import com.go4u.keepitfreshplatform.iam.domain.model.queries.GetUserByUsernameQuery;
import com.go4u.keepitfreshplatform.iam.domain.services.UserCommandService;
import com.go4u.keepitfreshplatform.iam.domain.services.UserQueryService;
import com.go4u.keepitfreshplatform.iam.interfaces.acl.IamContextFacade;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IamContextFacadeImpl implements IamContextFacade {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    /**
     * Constructor
     * @param userCommandService The user command service.
     * @param userQueryService The user query service.
     */
    public IamContextFacadeImpl(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    // inherited javadoc
    @Override
    public Long createUser(String username, String password) {
        var signUpCommand = new SignUpCommand(username, password, List.of(Role.getDefaultRole()));
        var result = userCommandService.handle(signUpCommand);
        if (result.isEmpty()) return 0L;
        return result.get().getId();
    }

    // inherited javadoc
    @Override
    public Long createUser(String username, String password, List<String> roleNames) {
        var roles = roleNames == null ? new ArrayList<Role>() : roleNames.stream().map(Role::toRoleFromName).toList();
        var signUpCommand = new SignUpCommand(username, password, roles);
        var result = userCommandService.handle(signUpCommand);
        if (result.isEmpty()) return 0L;
        return result.get().getId();
    }

    // inherited javadoc
    @Override
    public Long fetchUserIdByUsername(String username) {
        var getUserByUsernameQuery = new GetUserByUsernameQuery(username);
        var result = userQueryService.handle(getUserByUsernameQuery);
        if (result.isEmpty()) return 0L;
        return result.get().getId();
    }

    // inherited javadoc
    @Override
    public String fetchUsernameByUserId(Long userId) {
        var getUserByUserIdQuery = new GetUserByIdQuery(userId);
        var result = userQueryService.handle(getUserByUserIdQuery);
        if (result.isEmpty()) return Strings.EMPTY;
        return result.get().getUsername();
    }
}
