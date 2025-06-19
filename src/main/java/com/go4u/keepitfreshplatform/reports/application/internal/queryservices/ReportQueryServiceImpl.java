package com.go4u.keepitfreshplatform.reports.application.internal.queryservices;

import com.go4u.keepitfreshplatform.reports.domain.model.aggregates.Report;
import com.go4u.keepitfreshplatform.reports.domain.model.queries.GetAllReportsQuery;
import com.go4u.keepitfreshplatform.reports.domain.model.queries.GetReportByIdQuery;
import com.go4u.keepitfreshplatform.reports.domain.services.ReportQueryService;
import com.go4u.keepitfreshplatform.reports.infrastructure.persistence.jpa.repositories.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportQueryServiceImpl implements ReportQueryService {

    private final ReportRepository reportRepository;

    public ReportQueryServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public List<Report> handle(GetAllReportsQuery query) {
        return reportRepository.findAll();
    }

    @Override
    public Optional<Report> handle(GetReportByIdQuery query) {
        return reportRepository.findById(query.id());
    }
}
