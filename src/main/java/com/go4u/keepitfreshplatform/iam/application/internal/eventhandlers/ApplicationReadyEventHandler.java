package com.go4u.keepitfreshplatform.iam.application.internal.eventhandlers;

import com.go4u.keepitfreshplatform.iam.domain.model.commands.SeedRolesCommand;
import com.go4u.keepitfreshplatform.iam.domain.services.RoleCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;


@Service
public class ApplicationReadyEventHandler {
    private final RoleCommandService roleCommandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    /**
     * Constructor.
     *
     * @param roleCommandService the {@link RoleCommandService} role command service.
     */
    public ApplicationReadyEventHandler(RoleCommandService roleCommandService) {
        this.roleCommandService = roleCommandService;
    }

    /**
     * Event listener for the ApplicationReadyEvent.
     * <p>
     *     This method is triggered when the application is ready to serve requests.
     *     It is used to seed the roles in the database.
     * </p>
     *
     * @param event the {@link ApplicationReadyEvent} event.
     */
    @EventListener
    public void on(ApplicationReadyEvent event) {
        var applicationName = event.getApplicationContext().getId();
        LOGGER.info("Starting to verify if roles seeding is needed for {} at {}", applicationName, currentTimestamp());
        var seedRolesCommand = new SeedRolesCommand();
        roleCommandService.handle(seedRolesCommand);
        LOGGER.info("Roles seeding verification finished for {} at {}", applicationName, currentTimestamp());
    }

    /**
     * Get the current timestamp.
     *
     * @return the current timestamp.
     */
    private Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}