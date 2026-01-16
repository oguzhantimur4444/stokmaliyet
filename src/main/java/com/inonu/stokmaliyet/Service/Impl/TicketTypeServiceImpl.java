package com.inonu.stokmaliyet.Service.Impl;

import org.springframework.stereotype.Service;

import com.inonu.stokmaliyet.Entity.TicketType;
import com.inonu.stokmaliyet.Exception.TicketType.TicketTypeNotFoundException;
import com.inonu.stokmaliyet.Repository.TicketTypeRepository;
import com.inonu.stokmaliyet.Service.TicketTypeService;
import com.inonu.stokmaliyet.dto.Request.TicketTypeCreateRequest;
import com.inonu.stokmaliyet.dto.Request.TicketTypeUpdateRequest;
import com.inonu.stokmaliyet.dto.Response.TicketTypeResponse;
import com.inonu.stokmaliyet.Mapper.TicketTypeMapper;

import java.util.List;

@Service
public class TicketTypeServiceImpl implements TicketTypeService {

    private final TicketTypeRepository ticketTypeRepository;
    private final TicketTypeMapper ticketTypeMapper;

    public TicketTypeServiceImpl(TicketTypeRepository ticketTypeRepository, TicketTypeMapper ticketTypeMapper) {
        this.ticketTypeRepository = ticketTypeRepository;
        this.ticketTypeMapper = ticketTypeMapper;
    }

    @Override
    public List<TicketTypeResponse> getAllTicketTypes() {
        List<TicketType> ticketTypeList = this.ticketTypeRepository.findAll();
        return ticketTypeMapper.toResponseList(ticketTypeList);
    }

    @Override
    public TicketTypeResponse createTicketType(TicketTypeCreateRequest request) {
        TicketType ticketType = ticketTypeMapper.toEntity(request);
        TicketType toSave = ticketTypeRepository.save(ticketType);
        return ticketTypeMapper.toResponse(toSave);
    }

    @Override
    public TicketType getTicketTypeById(Long id) {
        return ticketTypeRepository.findById(id)
                .orElseThrow(() -> new TicketTypeNotFoundException("Ticket Type Not Found"));
    }

    @Override
    public TicketTypeResponse updateTicketType(TicketTypeUpdateRequest request) {

        TicketType ticketType = getTicketTypeById(request.id());
        ticketType.setName(request.name());
        ticketType.setUnitPrice(request.unitPrice());

        TicketType toUpdate = ticketTypeRepository.save(ticketType);
        return ticketTypeMapper.toResponse(toUpdate);

    }

    @Override
    public TicketTypeResponse deleteTicketType(Long id) {
        TicketType ticketType = getTicketTypeById(id);
        ticketTypeRepository.delete(ticketType);
        return ticketTypeMapper.toResponse(ticketType);
    }
}
