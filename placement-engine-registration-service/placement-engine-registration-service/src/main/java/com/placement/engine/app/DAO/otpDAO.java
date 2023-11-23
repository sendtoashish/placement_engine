package com.placement.engine.app.DAO;

import com.placement.engine.app.entity.OtpInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface otpDAO extends JpaRepository<OtpInfo,Long> {
}
