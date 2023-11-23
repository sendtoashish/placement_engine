package com.placement.engine.app.controller;

import com.placement.engine.app.entity.RecruiterRegistration;
import com.placement.engine.app.service.RecruiterRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/register/recruiter")
public class RecruiterController {

    @Autowired
    RecruiterRegistrationService recruiterRegistrationService;

    @PostMapping(value ="/save")
    public void saveRecruiter(@RequestBody RecruiterRegistration recruiter){
        recruiterRegistrationService.saveRecruiter(recruiter);
    }
}
