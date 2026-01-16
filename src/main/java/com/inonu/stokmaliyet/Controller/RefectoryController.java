package com.inonu.stokmaliyet.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inonu.stokmaliyet.Entity.Refectory;
import com.inonu.stokmaliyet.Service.RefectoryService;
import com.inonu.stokmaliyet.dto.Request.RefectoryCreateRequest;
import com.inonu.stokmaliyet.dto.Response.RefectoryResponse;
import com.inonu.stokmaliyet.dto.Response.RestResponse;

@RestController
@RequestMapping("/api/refactory")
@PreAuthorize("hasAnyRole('YEMEKHANE','ADMIN')")
public class RefectoryController {

    private final RefectoryService RefectoryService;

    public RefectoryController(RefectoryService RefectoryService) {
        this.RefectoryService = RefectoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<RestResponse<RefectoryResponse>> createRefectory(
            @RequestBody RefectoryCreateRequest RefectoryCreateRequest) {
        RefectoryResponse RefectoryResponse = RefectoryService.createRefectory(RefectoryCreateRequest);
        return new ResponseEntity<>(RestResponse.of(RefectoryResponse), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<Refectory>> getRefectoryById(@PathVariable("id") Long RefectoryId) {
        Refectory Refectory = RefectoryService.getRefectoryById(RefectoryId);
        return new ResponseEntity<>(RestResponse.of(Refectory), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<RestResponse<List<RefectoryResponse>>> getAllCategories() {
        List<RefectoryResponse> categories = RefectoryService.getAllRefectories();
        return new ResponseEntity<>(RestResponse.of(categories), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RestResponse<RefectoryResponse>> updateRefectory(
            @PathVariable("id") Long id,
            @RequestBody RefectoryCreateRequest RefectoryCreateRequest) {
        RefectoryResponse RefectoryResponse = RefectoryService.updateRefectory(id, RefectoryCreateRequest);
        return new ResponseEntity<>(RestResponse.of(RefectoryResponse), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RestResponse<RefectoryResponse>> deleteRefectory(@PathVariable("id") Long RefectoryId) {
        RefectoryResponse RefectoryResponse = RefectoryService.deleteRefectory(RefectoryId);
        return new ResponseEntity<>(RestResponse.of(RefectoryResponse), HttpStatus.OK);
    }

}
