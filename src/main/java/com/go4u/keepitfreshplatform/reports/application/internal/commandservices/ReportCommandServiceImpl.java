package com.go4u.keepitfreshplatform.reports.application.internal.commandservices;

import com.go4u.keepitfreshplatform.reports.domain.model.aggregates.Report;
import com.go4u.keepitfreshplatform.reports.domain.model.commands.CreateReportCommand;
import com.go4u.keepitfreshplatform.reports.domain.services.ReportCommandService;
import com.go4u.keepitfreshplatform.reports.infrastructure.persistence.jpa.repositories.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReportCommandServiceImpl implements ReportCommandService {

    private final ReportRepository reportRepository;

    public ReportCommandServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }


    @Override
    public Optional<Report> handle(CreateReportCommand command) {
        var report = new Report(command);
        var createdReport = reportRepository.save(report);

        return Optional.of(createdReport);
    }


}
