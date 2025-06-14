package com.go4u.keepitfreshplatform.reports.domain.model.commands;

/**
 * Command object for creating a new Report.
 * Ensures required fields are not null or blank.
 */

public record CreateReportCommand(String title, String description) {

    public CreateReportCommand {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or blank");
        }
        if (title.length() > 100) {
            throw new IllegalArgumentException("Title must not exceed 100 characters");
        }

        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or blank");
        }
        if (description.length() > 1000) {
            throw new IllegalArgumentException("Description must not exceed 1000 characters");
        }
    }
}