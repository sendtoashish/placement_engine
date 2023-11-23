package com.placement.engine.app.DAO;

import com.placement.engine.app.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDAO extends JpaRepository<Company,Long> {

    @Query("SELECT c FROM company_details c WHERE c.company_name= :company")
    public Company getCompanyByName(String company);
}
