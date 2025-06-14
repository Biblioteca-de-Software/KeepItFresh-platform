package com.go4u.keepitfreshplatform.reports.application.internal.commandservices;

import com.go4u.keepitfreshplatform.reports.domain.model.aggregates.Report;
import com.go4u.keepitfreshplatform.reports.domain.model.commands.CreateReportCommand;
import com.go4u.keepitfreshplatform.reports.domain.model.valueobjects.ReportId;
import com.go4u.keepitfreshplatform.reports.domain.services.ReportCommandService;
import com.go4u.keepitfreshplatform.reports.infrastructure.persistence.jpa.repositories.ReportRepository;
import org.springframework.stereotype.Service;

@Service
public class ReportCommandServiceImpl implements ReportCommandService {

    private final ReportRepository reportRepository;

    public ReportCommandServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Long handle(CreateReportCommand command) {

        // Regla de negocio: no duplicar título
        if (reportRepository.existsByTitle(command.title())) {
            throw new IllegalArgumentException(
                    "Report with title '" + command.title() + "' already exists."
            );
        }

        // Crear el agregado Report usando tu constructor actual
        var report = new Report(
                new ReportId(0L),               // Se generará cuando se persista
                command.title(),
                command.description()
        );

        try {
            reportRepository.save(report);
        } catch (Exception e) {
            throw new RuntimeException("Error saving report: " + e.getMessage(), e);
        }

        return report.getReportId();
    }
}
