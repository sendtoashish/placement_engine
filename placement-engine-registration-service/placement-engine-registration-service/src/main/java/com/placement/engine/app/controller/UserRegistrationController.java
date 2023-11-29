package com.placement.engine.app.controller;

import com.google.gson.Gson;
import com.placement.engine.app.entity.MailInfo;
import com.placement.engine.app.entity.Otp;
import com.placement.engine.app.entity.UserDetails;
import com.placement.engine.app.entity.UserRegistration;
import com.placement.engine.app.service.OtpGeneratorService;
import com.placement.engine.app.service.UserDetailsService;
import com.placement.engine.app.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/register/user")
public class UserRegistrationController {
    @Autowired
    private UserRegistrationService userRegistrationService;
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private OtpGeneratorService otpGeneratorService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private MailInfo mailInfo;

    @PostMapping(value = "/save")
    public ResponseEntity<String> saveBranch(@RequestBody UserRegistration user) {
        userRegistrationService.addUser(user);
        return ResponseEntity.ok().build();
    }



    @PostMapping(value = "/saveuserdetails", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Otp> saveBranch(@ModelAttribute UserDetails user, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        Otp o=userDetailsService.saveUserDetails(user, file);
        int otps =o.getOtp();
        mailInfo.setOtp(otps);
        mailInfo.setSendTo(user.getEmail());
        Gson gson = new Gson();
        String mailData = gson.toJson(mailInfo);
        kafkaTemplate.send("mailInfo",mailData);
        return ResponseEntity.ok().body(o);
    }

    @PostMapping(value="/otpVerify")
    public  ResponseEntity<String> verifyOTP(@RequestParam int otp , @RequestParam String uuid){
        String otpVerifyStatus=userDetailsService.otpVerification(otp,uuid);
        return ResponseEntity.ok().body(otpVerifyStatus);
    }

    @PostMapping (value="/getpassword")
    public ResponseEntity<String> getPassword(@RequestBody String username){
        String password= userRegistrationService.findByUsername(username);
        return ResponseEntity.ok().body(password);
    }

}
