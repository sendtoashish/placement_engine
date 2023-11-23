package com.placement.engine.app.controller;

import com.placement.engine.app.service.OtpGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value="/register/otpgenerate")
@RestController
public class OtpGeneratorController {

    @Autowired
    private OtpGeneratorService otpGeneratorService;

    @PostMapping
    public ResponseEntity<String> generateOtp(){
 //       otpGeneratorService.saveOtp();
        return ResponseEntity.ok().build();

    }
}
