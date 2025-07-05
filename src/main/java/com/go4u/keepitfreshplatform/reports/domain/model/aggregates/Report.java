package com.go4u.keepitfreshplatform.reports.domain.model.aggregates;

import com.go4u.keepitfreshplatform.reports.domain.model.commands.CreateReportCommand;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

@Getter
@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    private String title;

    // ✅ CAMBIO: details → description
    private String description;

    public Report() {
        // Default constructor for JPA
        super();
        this.title = Strings.EMPTY;
        this.description = Strings.EMPTY;
    }

    public Report(Long reportId, String title, String description) {
        this.title = title;
        this.description = description;
        this.reportId = reportId;
    }

    public Report(CreateReportCommand command) {
        this.title = command.title();
        this.description = command.description(); // ✅ debe coincidir
    }

    public Long getReportId() {
        return this.reportId;
    }
}
