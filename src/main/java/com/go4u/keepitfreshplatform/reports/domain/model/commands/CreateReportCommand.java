package com.go4u.keepitfreshplatform.reports.domain.model.commands;


public record CreateReportCommand(String title, String description) {
    public CreateReportCommand {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or blank");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or blank");
        }
    }
}
