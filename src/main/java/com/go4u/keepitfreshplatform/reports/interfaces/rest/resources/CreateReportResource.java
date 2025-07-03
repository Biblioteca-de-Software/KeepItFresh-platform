package com.go4u.keepitfreshplatform.reports.interfaces.rest.resources;

import org.apache.logging.log4j.util.Strings;

public record CreateReportResource(
    String title,
    String description
)
{
    public CreateReportResource() {
        this(Strings.EMPTY, Strings.EMPTY);
    }

    /* public CreateReportResource {
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
    }*/
}
