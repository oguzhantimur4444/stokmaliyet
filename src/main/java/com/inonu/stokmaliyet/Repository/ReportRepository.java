package com.inonu.stokmaliyet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inonu.stokmaliyet.Entity.Report;
import com.inonu.stokmaliyet.Enum.ReportType;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReportRepository extends JpaRepository<Report, Long> {
    Optional<Report> findByReportCreateDateAndReportType(LocalDate reportCreateDate, ReportType reportType);

    List<Report> findByReportCreateDateBetween(LocalDate startDate, LocalDate endDate);

    List<Report> findByReportType(ReportType reportType);

    List<Report> findByReportCreateDateBetweenAndReportType(LocalDate startDate, LocalDate endDate,
            ReportType reportType);
}
