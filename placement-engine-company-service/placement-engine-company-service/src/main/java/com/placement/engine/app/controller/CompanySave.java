package com.placement.engine.app.controller;

import com.placement.engine.app.entity.Company;
import com.placement.engine.app.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/com/company")
public class CompanySave {
    @Autowired
    private CompanyService companyService;
    @PostMapping(value="/save")
    private void saveCompanyDetails(@RequestBody Company company){
        companyService.saveCompanyDetails(company);
    }
}
