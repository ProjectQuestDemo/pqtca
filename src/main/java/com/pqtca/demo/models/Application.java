package com.pqtca.demo.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "application")
public class Application {
    /*
        ***************************************
        ***************************************
        Parameters for Application.class
        ***************************************
        ***************************************
    */

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    public long appssn;

    @Column
    public String middleName;

    @Column(nullable = false)
    @DateTimeFormat
    public Date dateOfBirth;

    @Column(nullable = false)
    public String ethnicity;

    @Column(nullable = false)
    public String streetAddress;

    @Column(nullable = false)
    public String city;

    @Column(nullable = false)
    public String state;

    @Column(nullable = false)
    public String county;

    @Column(nullable = false)
    public String phoneNumber;

    @Column
    public String altPhoneNumber;

    @Column(nullable = false)
    @Email
    public String email;

    @Column(nullable = false)
    public String altContactFirst;

    @Column(nullable = false)
    public String altContactLast;

    @Column(nullable = false)
    public String altContactNum;

    @Column(nullable = false)
    public String altContactAddy;

    @Column(nullable = false)
    public String altContactCity;

    @Column(nullable = false)
    public String altContactState;

    @Column(nullable = false)
    public boolean drugTest;

    @Column(nullable = false)
    public String socialServiceAid;

    @Column(nullable = false)
    public boolean felConvict;

    @Column
    public String fcExplanation;

    @Column(nullable = false)
    public String disability;

    @Column
    public String disExplanation;

    @Column(nullable = false)
    @NotEmpty(message = "SSN cannot be left blank")
    public boolean militarySrv;

    @Column(nullable = false)
    @NotEmpty(message = "SSN cannot be left blank")
    public boolean milSpouse;

    @Column(nullable = false)
    @NotEmpty(message = "SSN cannot be left blank")
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

    @OneToOne
    private User user;


    /*
        ***************************************
        ***************************************
        Constructors for the Application class.
        ***************************************
        ***************************************
    */

    // Default empty constructor
    public Application() {
    }

    public Application(long appssn, String middleName, Date dateOfBirth, String ethnicity) {
        this.appssn = appssn;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.ethnicity = ethnicity;
    }

    public Application(String streetAddress, String city, String state, String county, String phoneNumber, String altPhoneNumber, String email) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.county = county;
        this.phoneNumber = phoneNumber;
        this.altPhoneNumber = altPhoneNumber;
        this.email = email;
    }

    public Application(String altContactFirst, String altContactLast, String altContactNum, String altContactAddy, String altContactCity, String altContactState) {
        this.altContactFirst = altContactFirst;
        this.altContactLast = altContactLast;
        this.altContactNum = altContactNum;
        this.altContactAddy = altContactAddy;
        this.altContactCity = altContactCity;
        this.altContactState = altContactState;
    }

    public Application(boolean drugTest, String socialServiceAid, boolean felConvict, String fcExplanation, String disability, String disExplanation, boolean militarySrv, boolean milSpouse) {
        this.drugTest = drugTest;
        this.socialServiceAid = socialServiceAid;
        this.felConvict = felConvict;
        this.fcExplanation = fcExplanation;
        this.disability = disability;
        this.disExplanation = disExplanation;
        this.militarySrv = militarySrv;
        this.milSpouse = milSpouse;
    }

    public Application(String refferalSrc, String empId, Long gainEng, Long gainMath, String district, String precinct, Long census, Date dateComp) {
        this.refferalSrc = refferalSrc;
        this.empId = empId;
        this.gainEng = gainEng;
        this.gainMath = gainMath;
        this.district = district;
        this.precinct = precinct;
        this.census = census;
        this.dateComp = dateComp;
    }

    /*
        ***************************************
        ***************************************
        Getters and Setters for fields
        ***************************************
        ***************************************
    */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAppssn() {
        return appssn;
    }

    public void setAppssn(long appssn) {
        this.appssn = appssn;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAltPhoneNumber() {
        return altPhoneNumber;
    }

    public void setAltPhoneNumber(String altPhoneNumber) {
        this.altPhoneNumber = altPhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAltContactFirst() {
        return altContactFirst;
    }

    public void setAltContactFirst(String altContactFirst) {
        this.altContactFirst = altContactFirst;
    }

    public String getAltContactLast() {
        return altContactLast;
    }

    public void setAltContactLast(String altContactLast) {
        this.altContactLast = altContactLast;
    }

    public String getAltContactNum() {
        return altContactNum;
    }

    public void setAltContactNum(String altContactNum) {
        this.altContactNum = altContactNum;
    }

    public String getAltContactAddy() {
        return altContactAddy;
    }

    public void setAltContactAddy(String altContactAddy) {
        this.altContactAddy = altContactAddy;
    }

    public String getAltContactCity() {
        return altContactCity;
    }

    public void setAltContactCity(String altContactCity) {
        this.altContactCity = altContactCity;
    }

    public String getAltContactState() {
        return altContactState;
    }

    public void setAltContactState(String altContactState) {
        this.altContactState = altContactState;
    }

    public boolean isDrugTest() {
        return drugTest;
    }

    public void setDrugTest(boolean drugTest) {
        this.drugTest = drugTest;
    }

    public String getSocialServiceAid() {
        return socialServiceAid;
    }

    public void setSocialServiceAid(String socialServiceAid) {
        this.socialServiceAid = socialServiceAid;
    }

    public boolean isFelConvict() {
        return felConvict;
    }

    public void setFelConvict(boolean felConvict) {
        this.felConvict = felConvict;
    }

    public String getFcExplanation() {
        return fcExplanation;
    }

    public void setFcExplanation(String fcExplanation) {
        this.fcExplanation = fcExplanation;
    }

    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public String getDisExplanation() {
        return disExplanation;
    }

    public void setDisExplanation(String disExplanation) {
        this.disExplanation = disExplanation;
    }

    public boolean isMilitarySrv() {
        return militarySrv;
    }

    public void setMilitarySrv(boolean militarySrv) {
        this.militarySrv = militarySrv;
    }

    public boolean isMilSpouse() {
        return milSpouse;
    }

    public void setMilSpouse(boolean milSpouse) {
        this.milSpouse = milSpouse;
    }

    public String getRefferalSrc() {
        return refferalSrc;
    }

    public void setRefferalSrc(String refferalSrc) {
        this.refferalSrc = refferalSrc;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public Long getGainEng() {
        return gainEng;
    }

    public void setGainEng(Long gainEng) {
        this.gainEng = gainEng;
    }

    public Long getGainMath() {
        return gainMath;
    }

    public void setGainMath(Long gainMath) {
        this.gainMath = gainMath;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPrecinct() {
        return precinct;
    }

    public void setPrecinct(String precinct) {
        this.precinct = precinct;
    }

    public Long getCensus() {
        return census;
    }

    public void setCensus(Long census) {
        this.census = census;
    }

    public Date getDateComp() {
        return dateComp;
    }

    public void setDateComp(Date dateComp) {
        this.dateComp = dateComp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
