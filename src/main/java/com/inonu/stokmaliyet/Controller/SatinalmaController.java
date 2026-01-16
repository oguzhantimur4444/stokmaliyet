package com.inonu.stokmaliyet.Controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/satinalma")
@PreAuthorize("hasAnyRole('SATINALMA','ADMIN')")
public class SatinalmaController {

    @GetMapping("/panel")
    public String satinalmaPanel() {
        return "💰 Satınalma paneline eriştiniz.";
    }
}
