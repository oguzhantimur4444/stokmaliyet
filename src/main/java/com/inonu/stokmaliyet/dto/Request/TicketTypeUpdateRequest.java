package com.inonu.stokmaliyet.dto.Request;

public record TicketTypeUpdateRequest(
        Long id,
        String name,
        Double unitPrice) {
}
