package com.go4u.keepitfreshplatform.reports.domain.services;

import com.go4u.keepitfreshplatform.reports.domain.model.aggregates.Report;
import com.go4u.keepitfreshplatform.reports.domain.model.commands.CreateReportCommand;

import java.util.Optional;

/**
 * Domain service interface for handling commands related to reports.
 */
public interface ReportCommandService {
    /**
     * Handles the creation of a new report and returns its generated ID.
     * @param command command with title and description already validated
     * @return ID of the newly created report
     */
    Optional<Report> handle(CreateReportCommand command);
}
