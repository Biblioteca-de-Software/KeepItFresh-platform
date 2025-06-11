package com.go4u.keepitfreshplatform.reports.domain.model.aggregates;

import com.go4u.keepitfreshplatform.reports.domain.model.valueobjects.ReportId;
import com.go4u.keepitfreshplatform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
@Entity
public class Report extends AuditableAbstractAggregateRoot<Report> {

    private String title;
    private String details;

    @Embedded
    private ReportId reportId;
}
