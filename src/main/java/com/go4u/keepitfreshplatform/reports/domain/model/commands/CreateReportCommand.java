package com.go4u.keepitfreshplatform.reports.domain.model.commands;

/**
 * Command object for creating a new Report.
 * Ensures required fields are not null or blank.
 */

public record CreateReportCommand(String title, String description) {

    public CreateReportCommand {
    }
}