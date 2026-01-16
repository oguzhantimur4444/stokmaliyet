package com.inonu.stokmaliyet.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import com.inonu.stokmaliyet.Entity.TicketType;
import com.inonu.stokmaliyet.Service.TicketTypeService;
import com.inonu.stokmaliyet.dto.Request.TicketTypeCreateRequest;
import com.inonu.stokmaliyet.dto.Request.TicketTypeUpdateRequest;
import com.inonu.stokmaliyet.dto.Response.RestResponse;
import com.inonu.stokmaliyet.dto.Response.TicketTypeResponse;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/api/ticketType")
@PreAuthorize("hasAnyRole('YEMEKHANE','ADMIN','DEPO','SATINALMA')")
public class TicketTypeController {

    private final TicketTypeService ticketTypeService;

    public TicketTypeController(TicketTypeService ticketTypeService) {
        this.ticketTypeService = ticketTypeService;
    }

    @PostMapping("/create")
    public ResponseEntity<RestResponse<TicketTypeResponse>> createTicketType(
            @RequestBody TicketTypeCreateRequest request) {
        TicketTypeResponse ticketTypeResponse = ticketTypeService.createTicketType(request);
        return new ResponseEntity<>(RestResponse.of(ticketTypeResponse), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<TicketType>> getTicketTypeById(@PathVariable Long id) {
        TicketType ticketType = ticketTypeService.getTicketTypeById(id);
        return new ResponseEntity<>(RestResponse.of(ticketType), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<RestResponse<List<TicketTypeResponse>>> getAllTicketTypes() {
        List<TicketTypeResponse> ticketTypeResponseList = ticketTypeService.getAllTicketTypes();
        return new ResponseEntity<>(RestResponse.of(ticketTypeResponseList), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<RestResponse<TicketTypeResponse>> updateTicketType(
            @RequestBody TicketTypeUpdateRequest ticketTypeUpdateRequest) {
        TicketTypeResponse ticketTypeResponse = ticketTypeService.updateTicketType(ticketTypeUpdateRequest);
        return new ResponseEntity<>(RestResponse.of(ticketTypeResponse), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RestResponse<TicketTypeResponse>> deleteTicketType(@PathVariable Long id) {
        TicketTypeResponse ticketTypeResponse = ticketTypeService.deleteTicketType(id);
        return new ResponseEntity<>(RestResponse.of(ticketTypeResponse), HttpStatus.OK);
    }

}
