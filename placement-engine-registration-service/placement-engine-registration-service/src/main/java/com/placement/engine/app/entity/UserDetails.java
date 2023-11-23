package com.placement.engine.app.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;

@Entity(name="User_details")
@Data
@ToString
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String qualification;
    private int yearOfExperience;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private CV cv;
    @OneToOne
    private UserRegistration userRegistration;

}
