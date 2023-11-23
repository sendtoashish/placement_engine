package com.placement.engine.app.entity;


import lombok.Data;

import javax.persistence.*;

@Entity(name="UserAddress_details")
@Data
public class UserAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String city;
    private String state;
    private String street;

    @ManyToOne
    private UserRegistration user;
}
