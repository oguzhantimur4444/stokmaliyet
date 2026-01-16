package com.inonu.stokmaliyet.Controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import com.inonu.stokmaliyet.dto.Response.ReportResponse;
import com.inonu.stokmaliyet.Enum.ReportType;
import com.inonu.stokmaliyet.Service.ReportService;
import com.inonu.stokmaliyet.dto.Response.RestResponse;

import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/create/{reportType}")
    @PreAuthorize("hasAnyRole('SATINALMA','ADMIN','DEPO','YEMEKHANE')")
    public ResponseEntity<RestResponse<ReportResponse>> createReport(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @PathVariable ReportType reportType) {
        ReportResponse reportResponse = reportService.createReport(date, reportType);
        return new ResponseEntity<>(RestResponse.of(reportResponse), HttpStatus.OK);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('SATINALMA','ADMIN','DEPO','YEMEKHANE')")
    public ResponseEntity<RestResponse<List<ReportResponse>>> getAllReports() {
        List<ReportResponse> reportResponses = reportService.getAllReports();
        return new ResponseEntity<>(RestResponse.of(reportResponses), HttpStatus.OK);
    }

    @GetMapping("/date")
    public ResponseEntity<RestResponse<ReportResponse>> getReportDate(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam("reportType") ReportType reportType) {
        ReportResponse reportResponse = reportService.getReportByDate(date, reportType);
        if (reportResponse == null) {
            return new ResponseEntity<>(RestResponse.of(null), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(RestResponse.of(reportResponse), HttpStatus.OK);
    }

    @GetMapping("/betweenDate")
    public ResponseEntity<RestResponse<List<ReportResponse>>> getReportsBetweenDates(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        List<ReportResponse> reportResponses = reportService.getReportsBetweenDate(startDate, endDate);
        return new ResponseEntity<>(RestResponse.of(reportResponses), HttpStatus.OK);
    }

    // Test için manuel rapor oluşturma endpoint'i
    @PostMapping("/create-test")
    @PreAuthorize("hasAnyRole('SATINALMA','ADMIN','DEPO','YEMEKHANE')")
    public ResponseEntity<RestResponse<String>> createTestReport() {
        try {
            // Bugünün tarihi için günlük rapor oluştur
            LocalDate today = LocalDate.now();
            reportService.calculateDailyReport(today);
            return new ResponseEntity<>(RestResponse.of("Test raporu oluşturuldu: " + today), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(RestResponse.of("Rapor oluşturulamadı: " + e.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }

}
