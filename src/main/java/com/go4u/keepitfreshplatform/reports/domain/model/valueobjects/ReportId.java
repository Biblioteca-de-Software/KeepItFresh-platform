package com.go4u.keepitfreshplatform.reports.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Value object representing the unique identifier for a Report.
 * @summary
 * This class encapsulates the report ID as a non-negative Long value.
 * It is used to uniquely identify a report within the system.
 * @param reportId The unique identifier for the report, must be a non-negative number.
 * @see IllegalArgumentException
 */


@Embeddable
public record ReportId(Long reportId) {
    public ReportId {
        if (reportId == null || reportId < 0){
            throw new IllegalArgumentException("ReportId must be a non-negative number.");
        }
    }
}
