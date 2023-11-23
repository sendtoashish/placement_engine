package com.placement.engine.app.DAO;

import com.placement.engine.app.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsDAO extends JpaRepository <UserDetails,Long> {


}
