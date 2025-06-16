package com.go4u.keepitfreshplatform.iam.domain.services;
import com.go4u.keepitfreshplatform.iam.domain.model.commands.SeedRolesCommand;


public interface RoleCommandService {

    void handle(SeedRolesCommand command);


}
