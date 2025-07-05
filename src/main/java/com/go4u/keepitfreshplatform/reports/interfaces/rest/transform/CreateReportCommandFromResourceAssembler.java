package com.go4u.keepitfreshplatform.reports.interfaces.rest.transform;

import com.go4u.keepitfreshplatform.reports.domain.model.commands.CreateReportCommand;
import com.go4u.keepitfreshplatform.reports.interfaces.rest.resources.CreateReportResource;

public class CreateReportCommandFromResourceAssembler {
    public static CreateReportCommand toCommandFromResource(CreateReportResource resource) {
        return new CreateReportCommand(resource.getTitle(), resource.getDescription());
    }
}
