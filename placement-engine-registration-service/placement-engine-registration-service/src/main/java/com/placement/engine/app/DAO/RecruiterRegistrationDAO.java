package com.placement.engine.app.DAO;

import com.placement.engine.app.entity.RecruiterRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruiterRegistrationDAO extends JpaRepository<RecruiterRegistration,Long> {
}
