package com.placement.engine.app.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name="company_details")
@Data
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String company_name;
    private String company_domain;
    private long contact_no;
    private String company_email;
    @OneToOne(cascade=CascadeType.ALL)
    private Address address;
}
