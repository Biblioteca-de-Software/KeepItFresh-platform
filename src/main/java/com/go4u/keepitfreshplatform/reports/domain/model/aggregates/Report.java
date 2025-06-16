package com.go4u.keepitfreshplatform.reports.domain.model.aggregates;

import com.go4u.keepitfreshplatform.reports.domain.model.commands.CreateReportCommand;
import com.go4u.keepitfreshplatform.reports.domain.model.valueobjects.ReportId;
import com.go4u.keepitfreshplatform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.annotation.Id;

@Getter
@Entity
public class Report
        //extends AuditableAbstractAggregateRoot<Report>
 {

    @Getter
    private String title;

    @Getter
    private String details;

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private ReportId reportId;

    public Report(){
        // Default constructor for JPA
        super();
        this.title = Strings.EMPTY;
        this.details = Strings.EMPTY;

    }

    public Report(ReportId reportId, String title, String details) {
        this.title = title;
        this.details = details;
        this.reportId = reportId;
    }

    public Report(CreateReportCommand command) {
        this.title = command.title();
        this.details = command.description();
    }
    //public Report(Long reportId) {
        //this(new ReportId(reportId));
    //}

}
