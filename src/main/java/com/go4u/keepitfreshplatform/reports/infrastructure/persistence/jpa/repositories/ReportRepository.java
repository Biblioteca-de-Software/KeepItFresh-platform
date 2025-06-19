package com.go4u.keepitfreshplatform.reports.infrastructure.persistence.jpa.repositories;

import com.go4u.keepitfreshplatform.reports.domain.model.aggregates.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    /** Checks if a report already exists with the same title. */
    boolean existsByTitle(String title);
}
