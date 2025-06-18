package com.go4u.keepitfreshplatform.iam.domain.services;
import com.go4u.keepitfreshplatform.iam.domain.model.commands.SeedRolesCommand;


public interface RoleCommandService {
    /**
     * Handle seed roles command.
     *
     * @param command the {@link SeedRolesCommand} command
     */
    void handle(SeedRolesCommand command);
}