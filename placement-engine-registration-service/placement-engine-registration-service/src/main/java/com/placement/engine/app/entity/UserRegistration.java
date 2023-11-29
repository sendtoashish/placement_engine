package com.placement.engine.app.entity;


import lombok.Data;
import lombok.ToString;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;


@Entity(name="UserRegistration_details")
@Transactional
@Data
@ToString
public class UserRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String uuid;
    private String username;
    private String password;
    private String name;
    private String email;
    @Column(columnDefinition="tinyint(1) default 0")
    private boolean user_status;
    @OneToOne(mappedBy = "userRegistration")
    private UserDetails userDetails;
    @OneToOne(mappedBy = "userRegistration")
    private OtpInfo otpinfo;



}
