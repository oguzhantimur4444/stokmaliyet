package com.inonu.stokmaliyet.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.inonu.stokmaliyet.Enum.YemekTipi;
import com.inonu.stokmaliyet.Service.YemekRecetesiService;
import com.inonu.stokmaliyet.dto.Request.YemekRecetesiCreateRequest;
import com.inonu.stokmaliyet.dto.Response.RestResponse;
import com.inonu.stokmaliyet.dto.Response.YemekRecetesiResponse;

import java.util.List;

@RestController
@RequestMapping("/api/yemek-recetesi")
@PreAuthorize("hasAnyRole('ADMIN')")
public class YemekRecetesiController {

    private final YemekRecetesiService yemekRecetesiService;

    public YemekRecetesiController(YemekRecetesiService yemekRecetesiService) {
        this.yemekRecetesiService = yemekRecetesiService;
    }

    @GetMapping("/all")
    public ResponseEntity<RestResponse<List<YemekRecetesiResponse>>> getAllYemekReceteleri() {
        List<YemekRecetesiResponse> receteler = yemekRecetesiService.getAllYemekReceteleri();
        return new ResponseEntity<>(RestResponse.of(receteler), HttpStatus.OK);
    }

    @GetMapping("/by-tipi/{tipi}")
    public ResponseEntity<RestResponse<List<YemekRecetesiResponse>>> getYemekReceteleriByTipi(
            @PathVariable("tipi") YemekTipi tipi) {
        List<YemekRecetesiResponse> receteler = yemekRecetesiService.getYemekReceteleriByTipi(tipi);
        return new ResponseEntity<>(RestResponse.of(receteler), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<YemekRecetesiResponse>> getYemekRecetesiById(@PathVariable("id") Long id) {
        com.inonu.stokmaliyet.Entity.YemekRecetesi recete = yemekRecetesiService.getYemekRecetesiById(id);
        YemekRecetesiResponse response = new YemekRecetesiResponse(
                recete.getId(),
                recete.getAdi(),
                recete.getAciklama(),
                recete.getReceteDetaylari(),
                recete.getTipi());
        return new ResponseEntity<>(RestResponse.of(response), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<RestResponse<YemekRecetesiResponse>> createYemekRecetesi(
            @RequestBody YemekRecetesiCreateRequest request) {
        YemekRecetesiResponse recete = yemekRecetesiService.createYemekRecetesi(request);
        return new ResponseEntity<>(RestResponse.of(recete), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RestResponse<YemekRecetesiResponse>> updateYemekRecetesi(
            @PathVariable("id") Long id,
            @RequestBody YemekRecetesiCreateRequest request) {
        YemekRecetesiResponse recete = yemekRecetesiService.updateYemekRecetesi(id, request);
        return new ResponseEntity<>(RestResponse.of(recete), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RestResponse<YemekRecetesiResponse>> deleteYemekRecetesi(@PathVariable("id") Long id) {
        YemekRecetesiResponse recete = yemekRecetesiService.deleteYemekRecetesi(id);
        return new ResponseEntity<>(RestResponse.of(recete), HttpStatus.OK);
    }
}
