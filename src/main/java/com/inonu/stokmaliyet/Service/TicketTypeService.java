package com.inonu.stokmaliyet.Service;

import java.util.List;

import com.inonu.stokmaliyet.Entity.TicketType;
import com.inonu.stokmaliyet.dto.Request.TicketTypeCreateRequest;
import com.inonu.stokmaliyet.dto.Request.TicketTypeUpdateRequest;
import com.inonu.stokmaliyet.dto.Response.TicketTypeResponse;

public interface TicketTypeService {

    List<TicketTypeResponse> getAllTicketTypes();

    TicketTypeResponse createTicketType(TicketTypeCreateRequest request);

    TicketType getTicketTypeById(Long id);

    TicketTypeResponse updateTicketType(TicketTypeUpdateRequest request);

    TicketTypeResponse deleteTicketType(Long id);
}
