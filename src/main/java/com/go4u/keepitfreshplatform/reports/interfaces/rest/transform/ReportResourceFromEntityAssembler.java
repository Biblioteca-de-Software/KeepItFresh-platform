package com.go4u.keepitfreshplatform.reports.interfaces.rest.transform;

import com.go4u.keepitfreshplatform.reports.domain.model.aggregates.Report;
import com.go4u.keepitfreshplatform.reports.interfaces.rest.resources.ReportResource;


public class ReportResourceFromEntityAssembler {
    public static ReportResource toResourceFromEntity(Report report) {
        return new ReportResource(report.getReportId(), report.getTitle(),
                                  report.getDetails()
        );
    }
}
