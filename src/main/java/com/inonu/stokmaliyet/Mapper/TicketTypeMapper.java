package com.inonu.stokmaliyet.Mapper;

import com.inonu.stokmaliyet.Entity.TicketType;
import com.inonu.stokmaliyet.dto.Request.TicketTypeCreateRequest;
import com.inonu.stokmaliyet.dto.Response.TicketTypeResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TicketTypeMapper {

    public TicketTypeResponse toResponse(TicketType ticketType) {
        if (ticketType == null) {
            return null;
        }
        return new TicketTypeResponse(
                ticketType.getId(),
                ticketType.getName(),
                ticketType.getUnitPrice());
    }

    public List<TicketTypeResponse> toResponseList(List<TicketType> ticketTypeList) {
        if (ticketTypeList == null) {
            return null;
        }
        return ticketTypeList.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public TicketType toEntity(TicketTypeCreateRequest request) {
        if (request == null) {
            return null;
        }
        TicketType ticketType = new TicketType();
        ticketType.setName(request.name());
        ticketType.setUnitPrice(request.unitPrice());
        return ticketType;
    }
}
