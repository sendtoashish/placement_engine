package com.placement.engine.app.DAO;


import com.placement.engine.app.entity.CV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVDAO extends JpaRepository<CV,Long> {
}
