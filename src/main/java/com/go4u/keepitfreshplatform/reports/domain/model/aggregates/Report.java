package com.go4u.keepitfreshplatform.reports.domain.model.aggregates;

import com.go4u.keepitfreshplatform.reports.domain.model.commands.CreateReportCommand;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

@Getter
@Entity
public class Report
        //extends AuditableAbstractAggregateRoot<Report>
 {

     @Id
     @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
     private Long reportId;


    @Getter
    private String title;

    @Getter
    private String details;


    public Report(){
        // Default constructor for JPA
        super();
        this.title = Strings.EMPTY;
        this.details = Strings.EMPTY;

    }

    public Report(Long reportId, String title, String details) {
        this.title = title;
        this.details = details;
        this.reportId = reportId;
    }

    public Report(CreateReportCommand command) {
        this.title = command.title();
        this.details = command.description();
    }

    public Long getReportId(){
        return this.reportId;
    }
    //public Report(Long reportId) {
        //this(new ReportId(reportId));
    //}

}
