package com.go4u.keepitfreshplatform.iam.domain.services;
import com.go4u.keepitfreshplatform.iam.domain.model.commands.SeedRolesCommand;
public interface RoleCommandsService {
void handle(SeedRolesCommand command);
}
