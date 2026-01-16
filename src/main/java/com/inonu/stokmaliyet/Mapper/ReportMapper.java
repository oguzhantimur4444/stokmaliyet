package com.inonu.stokmaliyet.Mapper;

import com.inonu.stokmaliyet.Entity.Report;
import com.inonu.stokmaliyet.dto.Response.ReportResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReportMapper {

    public ReportResponse toResponse(Report report) {
        if (report == null) {
            return null;
        }
        return new ReportResponse(
                report.getId(),
                report.getReportType(),
                report.getReportCreateDate(),
                report.getTicketQuantity(),
                report.getTotalTicketPrice(),
                report.getTotalPersonQuantity(),
                report.getTotalMaterialPrice(),
                report.getAveragePersonCost(),
                report.getAverageTicketCost(),
                report.getLeftoverMealCount());
    }

    public List<ReportResponse> toResponseList(List<Report> reportList) {
        if (reportList == null) {
            return null;
        }
        return reportList.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
