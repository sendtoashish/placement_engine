package com.placement.engine.app.entity;


import lombok.Data;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;


@Entity(name="recruiterregistration_details")
@Data
@Transactional
public class RecruiterRegistration {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private long contact_no;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private Company company;
//    @OneToOne(cascade = CascadeType.ALL)
//    private C comp
}
