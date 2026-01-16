package com.inonu.stokmaliyet.dto.Request;

import java.time.LocalDate;

import com.inonu.stokmaliyet.Enum.ReportType;

public record ReportCreateRequest(
        // String reportType, start ve end tarihine gore belirlenebilir
        LocalDate reportDate,
        ReportType reportType,
        int ticketQuantity,
        // Double totalTicketPrice,
        int totalPersonQuantity,
        Double totalMaterialPrice,
        Double totalCleanPrice) {

}
