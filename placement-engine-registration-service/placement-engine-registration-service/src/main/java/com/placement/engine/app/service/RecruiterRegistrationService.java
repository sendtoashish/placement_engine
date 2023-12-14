package com.placement.engine.app.service;

import com.placement.engine.app.DAO.CompanyDAO;
import com.placement.engine.app.DAO.RecruiterRegistrationDAO;
import com.placement.engine.app.entity.Company;
import com.placement.engine.app.entity.RecruiterRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RecruiterRegistrationService {

    @Autowired
   private RecruiterRegistrationDAO recruiterRegistrationDAO;
    @Autowired
    private CompanyDAO companyDAO;

    public void saveRecruiter(RecruiterRegistration recruiter){

        String companyName = recruiter.getCompany().getCompany_name();
        Company company = recruiter.getCompany();
        Company companyFromDb = companyDAO.getCompanyByName(companyName);
        if(companyFromDb != null){
            recruiter.setCompany(companyFromDb);
        }else{
            Company newCompany = companyDAO.save(company);
            recruiter.setCompany(company);
        }
        recruiterRegistrationDAO.save(recruiter);
    }
}
