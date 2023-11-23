package com.placement.engine.app.DAO;

import com.placement.engine.app.entity.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistrationDAO extends JpaRepository<UserRegistration,Long> {

    @Query("SELECT u FROM UserRegistration_details u WHERE email = :email")
    public UserRegistration findUserByemail(String email);

    @Query("SELECT u FROM UserRegistration_details u WHERE uuid = :uuid"  )
    public UserRegistration findUserByUID(String uuid);
}
