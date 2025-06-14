package com.go4u.keepitfreshplatform.reports.domain.model.queries;

/**
 * Query used to request all reports from the system.
 *
 * This record represents a simple query with no filters or parameters,
 * allowing the retrieval of all existing reports.
 */
public record GetAllReportsQuery() {
    public GetAllReportsQuery {
        // No validation required for now since there are no fields.
        // Structure maintained for future extensibility.
    }
}
