package com.go4u.keepitfreshplatform.iam.application.internal.evenhandlers;
import com.go4u.keepitfreshplatform.iam.domain.model.commands.SeedRolesCommand;
import com.go4u.keepitfreshplatform.iam.domain.services.RoleCommandsService;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class ApplicationReadyEventHandler {

    private final RoleCommandsService roleCommandsService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    public ApplicationReadyEventHandler(RoleCommandsService roleCommandsService) {
        this.roleCommandsService = roleCommandsService;
    }

    @EventListener
    public void on(ApplicationReadyEvent event) {
        var ApplicationName = event.getApplicationContext().getId();
        LOGGER.info("Starting to verify if rules seeding is needed for {} at {}", ApplicationName, currentTimestamp());
        var seedRolesCommand = new SeedRolesCommand();
        roleCommandsService.handle(seedRolesCommand);
        LOGGER.info("Role seeding verification finished for {} at {}", ApplicationName, currentTimestamp());

    }
    private Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}