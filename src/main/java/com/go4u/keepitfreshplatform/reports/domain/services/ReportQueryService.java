package com.go4u.keepitfreshplatform.reports.domain.services;

import com.go4u.keepitfreshplatform.reports.domain.model.aggregates.Report;
import com.go4u.keepitfreshplatform.reports.domain.model.queries.GetAllReportsQuery;
import com.go4u.keepitfreshplatform.reports.domain.model.queries.GetReportByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ReportQueryService {
    List<Report> handle(GetAllReportsQuery query);
    Optional<Report> handle(GetReportByIdQuery query);
}
