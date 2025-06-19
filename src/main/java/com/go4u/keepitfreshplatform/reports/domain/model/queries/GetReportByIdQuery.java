package com.go4u.keepitfreshplatform.reports.domain.model.queries;

public record GetReportByIdQuery(Long id) {

    public GetReportByIdQuery {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Report cannot be null or have a non-positive ID");
        }
    }
}
