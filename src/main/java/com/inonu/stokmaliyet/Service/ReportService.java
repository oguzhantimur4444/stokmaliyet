package com.inonu.stokmaliyet.Service;

import java.time.LocalDate;
import java.util.List;

import com.inonu.stokmaliyet.Enum.ReportType;
import com.inonu.stokmaliyet.dto.Response.ReportResponse;

public interface ReportService {

    ReportResponse createReport(LocalDate date, ReportType reportType);

    List<ReportResponse> getAllReports();

    ReportResponse calculateDailyReport(LocalDate date);

    ReportResponse calculateWeeklyReport(LocalDate date);

    ReportResponse calculateMonthlyReport(LocalDate date);

    ReportResponse calculateYearlyReport(LocalDate date);

    ReportResponse getReportByDate(LocalDate date, ReportType reportType);

    List<ReportResponse> getReportsBetweenDate(LocalDate startDate, LocalDate endDate);

}
