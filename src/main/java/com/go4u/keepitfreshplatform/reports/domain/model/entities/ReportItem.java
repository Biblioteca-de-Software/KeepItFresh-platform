package com.go4u.keepitfreshplatform.reports.domain.model.entities;

import com.go4u.keepitfreshplatform.reports.domain.model.aggregates.Report;
import com.go4u.keepitfreshplatform.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

public class ReportItem extends AuditableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "report_id", nullable = false)
    private Report report;

    @NotNull
    private String title;

    @NotNull
    private String details;

    public ReportItem(Report report, String title, String details) {
        this.report = report;
        this.title = title;
        this.details = details;
    }
}
