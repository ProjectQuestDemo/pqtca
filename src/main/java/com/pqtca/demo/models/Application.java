package com.pqtca.demo.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
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
    private long appssn;

    @Column
    private String middleName;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(nullable = false)
    @DateTimeFormat
    private Date dateOfBirth;

    @Column(nullable = false)
    private String ethnicity;

    @Column(nullable = false)
    private String streetAddress;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String county;

    @Column(nullable = false)
    @Size(min = 5, max = 5, message = "Only 5 digits please.")
    private long zip;

    @Column(nullable = false)
    private String phoneNumber;

    @Column
    private String altPhoneNumber;

    @Column(nullable = false)
    @Email
    private String email;

    @Column(nullable = false)
    private String emerContactFirst;

    @Column(nullable = false)
    private String emerContactLast;

    @Column(nullable = false)
    private String emerContactRel;

    @Column(nullable = false)
    private String emerContactNum;

    @Column(nullable = false)
    private String emerContactAddy;

    @Column(nullable = false)
    private String emerContactCity;

    @Column(nullable = false)
    private String emerContactState;

    @Column(nullable = false)
    private String maritalStatus;

    @Column(nullable = false)
    private String familyStatus;

    @Column(nullable = false)
    private String totalInHouse;

    @Column(nullable = false)
    private String depUnderFive;

    @Column(nullable = false)
    private String depOverFive;

    @Column(nullable = false)
    private String depOverEighteen;

    @Column(nullable = false)
    private boolean drugTest;

    @Column(nullable = false)
    private boolean tanf;

    @Column(nullable = false)
    private boolean snap;

    @Column(nullable = false)
    private boolean ssh;

    @Column(nullable = false)
    private boolean ssi;

    @Column(nullable = false)
    private boolean ssdi;

    @Column(nullable = false)
    private boolean wic;

    @Column(nullable = false)
    private boolean unemp;

    @Column(nullable = false)
    private boolean felConvict;

    @Column
    private String fcExplanation;

    @Column(nullable = false)
    private String disability;

    @Column
    private String disExplanation;

    @Column(nullable = false)
    @NotEmpty(message = "Required")
    private boolean militarySrv;

    @Column(nullable = false)
    @NotEmpty(message = "Required")
    private boolean milSpouse;

    @Column(nullable = false)
    @NotEmpty(message = "Required")
    private String referralSrc;

    @Column
    private String empId;

    @Column
    private Long gainEng;

    @Column
    private Long gainMath;

    @Column
    private String district;

    @Column
    private String precinct;

    @Column
    private Long census;

    @Column
    @DateTimeFormat
    private Date dateComp;

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

    public Application(long appssn, String middleName, String firstName, String
            lastName, Date dateOfBirth, String ethnicity, String streetAddress, String
            city, String state, String county, long zip, String phoneNumber, String
            altPhoneNumber, String email, String emerContactFirst, String
            emerContactLast, String emerContactRel, String emerContactNum, String
            emerContactAddy, String emerContactCity, String emerContactState, String
            maritalStatus, String familyStatus, String totalInHouse, String
            depUnderFive, String depOverFive, String depOverEighteen, boolean
            drugTest, boolean tanf, boolean snap, boolean ssh, boolean ssi, boolean
            ssdi, boolean wic, boolean unemp, boolean felConvict, String fcExplanation, String disability, String disExplanation, boolean militarySrv, boolean milSpouse, String referralSrc, String empId, Long gainEng, Long gainMath, String district, String precinct, Long census, Date dateComp, User user) {
        this.appssn = appssn;
        this.middleName = middleName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.ethnicity = ethnicity;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.county = county;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.altPhoneNumber = altPhoneNumber;
        this.email = email;
        this.emerContactFirst = emerContactFirst;
        this.emerContactLast = emerContactLast;
        this.emerContactRel = emerContactRel;
        this.emerContactNum = emerContactNum;
        this.emerContactAddy = emerContactAddy;
        this.emerContactCity = emerContactCity;
        this.emerContactState = emerContactState;
        this.maritalStatus = maritalStatus;
        this.familyStatus = familyStatus;
        this.totalInHouse = totalInHouse;
        this.depUnderFive = depUnderFive;
        this.depOverFive = depOverFive;
        this.depOverEighteen = depOverEighteen;
        this.drugTest = drugTest;
        this.tanf = tanf;
        this.snap = snap;
        this.ssh = ssh;
        this.ssi = ssi;
        this.ssdi = ssdi;
        this.wic = wic;
        this.unemp = unemp;
        this.felConvict = felConvict;
        this.fcExplanation = fcExplanation;
        this.disability = disability;
        this.disExplanation = disExplanation;
        this.militarySrv = militarySrv;
        this.milSpouse = milSpouse;
        this.referralSrc = referralSrc;
        this.empId = empId;
        this.gainEng = gainEng;
        this.gainMath = gainMath;
        this.district = district;
        this.precinct = precinct;
        this.census = census;
        this.dateComp = dateComp;
        this.user = user;
    }

    public Application(long appssn, String middleName, String firstName, String
            lastName, Date dateOfBirth, String ethnicity, String streetAddress, String
            city, String state, String county, long zip, String phoneNumber, String
            altPhoneNumber, String email, String emerContactFirst, String
            emerContactLast, String emerContactRel, String emerContactNum, String
            emerContactAddy, String emerContactCity, String emerContactState, String
            maritalStatus, String familyStatus, String totalInHouse, String
            depUnderFive, String depOverFive, String depOverEighteen, boolean
            drugTest, boolean tanf, boolean snap, boolean ssh, boolean ssi, boolean
            ssdi, boolean wic, boolean unemp, boolean felConvict, String
            fcExplanation, String disability, String disExplanation, boolean militarySrv, boolean milSpouse, String referralSrc, User user) {
        this.appssn = appssn;
        this.middleName = middleName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.ethnicity = ethnicity;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.county = county;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.altPhoneNumber = altPhoneNumber;
        this.email = email;
        this.emerContactFirst = emerContactFirst;
        this.emerContactLast = emerContactLast;
        this.emerContactRel = emerContactRel;
        this.emerContactNum = emerContactNum;
        this.emerContactAddy = emerContactAddy;
        this.emerContactCity = emerContactCity;
        this.emerContactState = emerContactState;
        this.maritalStatus = maritalStatus;
        this.familyStatus = familyStatus;
        this.totalInHouse = totalInHouse;
        this.depUnderFive = depUnderFive;
        this.depOverFive = depOverFive;
        this.depOverEighteen = depOverEighteen;
        this.drugTest = drugTest;
        this.tanf = tanf;
        this.snap = snap;
        this.ssh = ssh;
        this.ssi = ssi;
        this.ssdi = ssdi;
        this.wic = wic;
        this.unemp = unemp;
        this.felConvict = felConvict;
        this.fcExplanation = fcExplanation;
        this.disability = disability;
        this.disExplanation = disExplanation;
        this.militarySrv = militarySrv;
        this.milSpouse = milSpouse;
        this.referralSrc = referralSrc;
        this.user = user;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public long getZip() {
        return zip;
    }

    public void setZip(long zip) {
        this.zip = zip;
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

    public String getEmerContactFirst() {
        return emerContactFirst;
    }

    public void setEmerContactFirst(String emerContactFirst) {
        this.emerContactFirst = emerContactFirst;
    }

    public String getEmerContactLast() {
        return emerContactLast;
    }

    public void setEmerContactLast(String emerContactLast) {
        this.emerContactLast = emerContactLast;
    }

    public String getEmerContactRel() {
        return emerContactRel;
    }

    public void setEmerContactRel(String emerContactRel) {
        this.emerContactRel = emerContactRel;
    }

    public String getEmerContactNum() {
        return emerContactNum;
    }

    public void setEmerContactNum(String emerContactNum) {
        this.emerContactNum = emerContactNum;
    }

    public String getEmerContactAddy() {
        return emerContactAddy;
    }

    public void setEmerContactAddy(String emerContactAddy) {
        this.emerContactAddy = emerContactAddy;
    }

    public String getEmerContactCity() {
        return emerContactCity;
    }

    public void setEmerContactCity(String emerContactCity) {
        this.emerContactCity = emerContactCity;
    }

    public String getEmerContactState() {
        return emerContactState;
    }

    public void setEmerContactState(String emerContactState) {
        this.emerContactState = emerContactState;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(String familyStatus) {
        this.familyStatus = familyStatus;
    }

    public String getTotalInHouse() {
        return totalInHouse;
    }

    public void setTotalInHouse(String totalInHouse) {
        this.totalInHouse = totalInHouse;
    }

    public String getDepUnderFive() {
        return depUnderFive;
    }

    public void setDepUnderFive(String depUnderFive) {
        this.depUnderFive = depUnderFive;
    }

    public String getDepOverFive() {
        return depOverFive;
    }

    public void setDepOverFive(String depOverFive) {
        this.depOverFive = depOverFive;
    }

    public String getDepOverEighteen() {
        return depOverEighteen;
    }

    public void setDepOverEighteen(String depOverEighteen) {
        this.depOverEighteen = depOverEighteen;
    }

    public boolean isDrugTest() {
        return drugTest;
    }

    public void setDrugTest(boolean drugTest) {
        this.drugTest = drugTest;
    }

    public boolean isTanf() {
        return tanf;
    }

    public void setTanf(boolean tanf) {
        this.tanf = tanf;
    }

    public boolean isSnap() {
        return snap;
    }

    public void setSnap(boolean snap) {
        this.snap = snap;
    }

    public boolean isSsh() {
        return ssh;
    }

    public void setSsh(boolean ssh) {
        this.ssh = ssh;
    }

    public boolean isSsi() {
        return ssi;
    }

    public void setSsi(boolean ssi) {
        this.ssi = ssi;
    }

    public boolean isSsdi() {
        return ssdi;
    }

    public void setSsdi(boolean ssdi) {
        this.ssdi = ssdi;
    }

    public boolean isWic() {
        return wic;
    }

    public void setWic(boolean wic) {
        this.wic = wic;
    }

    public boolean isUnemp() {
        return unemp;
    }

    public void setUnemp(boolean unemp) {
        this.unemp = unemp;
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

    public String getReferralSrc() {
        return referralSrc;
    }

    public void setReferralSrc(String referralSrc) {
        this.referralSrc = referralSrc;
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
