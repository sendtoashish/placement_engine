package com.placement.engine.app.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Data
@ToString
public class OtpInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int otpValue;
  //  @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Time time;

    @OneToOne
    private UserRegistration userRegistration;

}
