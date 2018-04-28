package com.pqtca.demo.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    public long userId;

    @Column(nullable = false)
    @NotEmpty(message = "SSN cannot be left blank")
    public long appssn;

    @Column
    public String middleName;

    @Column
    public String streetAddress;

    @Column
    public String city;

    @Column
    public String state;

    @Column
    public String county;

    @Column
    public String phoneNumber;

    @Column
    public String altPhoneNumber;

    @Column
    @DateTimeFormat
    public Date dateOfBirth;

    @Column
    @Email
    public String email;

    @Column
    public String ethnicity;

    @Column
    public String altContactFirst;

    @Column
    public String altContactLast;

    @Column
    public String altContactNum;

    @Column
    public String altContactAddy;

    @Column
    public String altContactCity;

    @Column
    public String altContactState;

    @Column
    public String drugTest;

    @Column
    public String socialServiceAid;

    @Column
    public String felConvict;

    @Column
    public String fcExplanation;

    @Column
    public String disability;

    @Column
    public String disExplanation;

    @Column
    public String militarySrv;

    @Column
    public String milSpouse;

    @Column
    public String refferalSrc;

    @Column
    public String empId;

    @Column
    public Long gainEng;

    @Column
    public Long gainMath;

    @Column
    public String district;

    @Column
    public String precinct;

    @Column
    public Long census;

    @Column
    @DateTimeFormat
    public Date dateComp;


}
