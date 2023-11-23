package com.placement.engine.app.service;

import com.placement.engine.app.DAO.CompanyDAO;
import com.placement.engine.app.entity.Company;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CompanyService {

    @Autowired
    CompanyDAO companyDAO;

    public void saveCompanyDetails(Company company){
        log.info("Saving Company Details");
        try {
            companyDAO.save(company);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
