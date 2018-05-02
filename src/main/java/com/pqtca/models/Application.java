package com.pqtca.models;

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
    private long appssn;

    @Column
    private String aMiddleName;

    @Column
    private String aFirstName;

    @Column
    private String aLastName;

    @Column(nullable = false)
    private String aDateOfBirth;

    @Column(nullable = false)
    private String aEthnicity;

    @Column(nullable = false)
    private String bStreetAddress;

    @Column(nullable = false)
    private String bCity;

    @Column(nullable = false)
    private String bState;

    @Column(nullable = false)
    private String bCounty;

    @Column(nullable = false)
    private long bZip;

    @Column(nullable = false)
    private String bPhoneNumber;

    @Column
    private String bAltPhoneNumber;

    @Column(nullable = false)
    private String bEmail;

    @Column(nullable = false)
    private String cEmerContactFirst;

    @Column(nullable = false)
    private String cEmerContactLast;

    @Column(nullable = false)
    private String cEmerContactRel;

    @Column
    private String cEmerContactNum;

    /*@Column
    private String cEmerContactAddy;

    @Column
    private String cEmerContactCity;

    @Column
    private String cEmerContactbState;*/

    @Column(nullable = false)
    private String dMaritalStatus;

    @Column(nullable = false)
    private String dfamilyStatus;

    @Column(nullable = false)
    private String dTotalInHouse;

    @Column(nullable = false)
    private String dDepUnderFive;

    @Column(nullable = false)
    private String dDepOverFive;

    @Column(nullable = false)
    private String dDepOverEighteen;

    @Column(nullable = false)
    private boolean eDrugTest;

    @Column(nullable = false)
    private boolean eTanf;

    @Column(nullable = false)
    private boolean eSnap;

    @Column(nullable = false)
    private boolean eSsh;

    @Column(nullable = false)
    private boolean eSsi;

    @Column(nullable = false)
    private boolean eSsdi;

    @Column(nullable = false)
    private boolean eWic;

    @Column(nullable = false)
    private boolean eUnemp;

    @Column(nullable = false)
    private boolean eFelConvict;

    @Column
    private String eFcExplanation;

    @Column(nullable = false)
    private String eDisability;

    @Column
    private String eDisExplanation;

    @Column(nullable = false)
    private String eMilitarySrv;

    @Column(nullable = false)
    private boolean eMilSpouse;

    @Column(nullable = false)
    @NotEmpty(message = "Required")
    private String eReferralSrc;

    @Column
    private String fEmpId;

    @Column
    private Long fGainEng;

    @Column
    private Long fGainMath;

    @Column
    private String fDistrict;

    @Column
    private String fPrecinct;

    @Column
    private Long fCensus;

    @Column
    @DateTimeFormat
    private Date fDateComp;

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

    public Application(long appssn, String aMiddleName, String aFirstName, String
            aLastName, String aDateOfBirth, String aEthnicity, String bStreetAddreeSsddress, String bCity, String bState, String bCounty, long bZip, String bPhoneNumber, String bAltPhoneNumber, String bEmail, String cEmerContactFirst, String cEmerContactLast, String cEmerContactRel, String cEmerContactNum, String dMaritalStatus, String dfamilyStatus, String dTotalInHouse, String dDepUnderFive, String dDepOverFive, String dDepOverEighteen, boolean eDrugTest, boolean eTanf, boolean eSnap, boolean eSsh, boolean eSsi, boolean eSsdi, boolean eWic, boolean eUnemp, boolean eFelConvict, String eFcExplanation, String eDisability, String eDisExplanation, String eMilitarySrv, boolean eMilSpouse, String eReferralSrc) {
        this.appssn = appssn;
        this.aMiddleName = aMiddleName;
        this.aFirstName = aFirstName;
        this.aLastName = aLastName;
        this.aDateOfBirth = aDateOfBirth;
        this.aEthnicity = aEthnicity;
        this.bStreetAddress = bStreetAddress;
        this.bCity =bCity;
        this.bState = bState;
        this.bCounty = bCounty;
        this.bZip = bZip;
        this.bPhoneNumber = bPhoneNumber;
        this.bAltPhoneNumber = bAltPhoneNumber;
        this.bEmail = bEmail;
        this.cEmerContactFirst = cEmerContactFirst;
        this.cEmerContactLast = cEmerContactLast;
        this.cEmerContactRel = cEmerContactRel;
        this.cEmerContactNum = cEmerContactNum;
        this.dMaritalStatus = dMaritalStatus;
        this.dfamilyStatus = dfamilyStatus;
        this.dTotalInHouse = dTotalInHouse;
        this.dDepUnderFive = dDepUnderFive;
        this.dDepOverFive = dDepOverFive;
        this.dDepOverEighteen = dDepOverEighteen;
        this.eDrugTest = eDrugTest;
        this.eTanf = eTanf;
        this.eSnap = eSnap;
        this.eSsh = eSsh;
        this.eSsi = eSsi;
        this.eSsdi = eSsdi;
        this.eWic = eWic;
        this.eUnemp = eUnemp;
        this.eFelConvict = eFelConvict;
        this.eFcExplanation = eFcExplanation;
        this.eDisability = eDisability;
        this.eDisExplanation = eDisExplanation;
        this.eMilitarySrv = eMilitarySrv;
        this.eMilSpouse = eMilSpouse;
        this.eReferralSrc = eReferralSrc;
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

    public String getaFirstName() {
        return aFirstName;
    }

    public void setaFirstName(String aFirstName) {
        this.aFirstName = aFirstName;
    }

    public String getaLastName() {
        return aLastName;
    }

    public void setaLastName(String aLastName) {
        this.aLastName = aLastName;
    }

    public String getaMiddleName() {
        return aMiddleName;
    }

    public void setaMiddleName(String aMiddleName) {
        this.aMiddleName = aMiddleName;
    }

    public String getaDateOfBirth() {
        return aDateOfBirth;
    }

    public void setaDateOfBirth(String aDateOfBirth) {
        this.aDateOfBirth = aDateOfBirth;
    }

    public String getaEthnicity() {
        return aEthnicity;
    }

    public void setaEthnicity(String aEthnicity) {
        this.aEthnicity = aEthnicity;
    }

    public String getbStreetAddress() {
        return bStreetAddress;
    }

    public void setbStreetAddress(String bStreetAddress) {
        this.bStreetAddress = bStreetAddress;
    }

    public String getbCity() {
        return bCity;
    }

    public void setbCity(String bCity) {
        this.bCity = bCity;
    }

    public String getbState() {
        return bState;
    }

    public void setbState(String bState) {
        this.bState = bState;
    }

    public String getbCounty() {
        return bCounty;
    }

    public void setbCounty(String bCounty) {
        this.bCounty = bCounty;
    }

    public long getbZip() {
        return bZip;
    }

    public void setbZip(long bZip) {
        this.bZip = bZip;
    }

    public String getbPhoneNumber() {
        return bPhoneNumber;
    }

    public void setbPhoneNumber(String bPhoneNumber) {
        this.bPhoneNumber = bPhoneNumber;
    }

    public String getbAltPhoneNumber() {
        return bAltPhoneNumber;
    }

    public void setbAltPhoneNumber(String bAltPhoneNumber) {
        this.bAltPhoneNumber = bAltPhoneNumber;
    }

    public String getbEmail() {
        return bEmail;
    }

    public void setbEmail(String bEmail) {
        this.bEmail = bEmail;
    }

    public String getcEmerContactFirst() {
        return cEmerContactFirst;
    }

    public void setcEmerContactFirst(String cEmerContactFirst) {
        this.cEmerContactFirst = cEmerContactFirst;
    }

    public String getcEmerContactLast() {
        return cEmerContactLast;
    }

    public void setcEmerContactLast(String cEmerContactLast) {
        this.cEmerContactLast = cEmerContactLast;
    }

    public String getcEmerContactRel() {
        return cEmerContactRel;
    }

    public void setcEmerContactRel(String cEmerContactRel) {
        this.cEmerContactRel = cEmerContactRel;
    }

    public String getcEmerContactNum() {
        return cEmerContactNum;
    }

    public void setcEmerContactNum(String cEmerContactNum) {
        this.cEmerContactNum = cEmerContactNum;
    }

    /*public String getcEmerContactAddy() {
        return cEmerContactAddy;
    }

    public void setcEmerContactAddy(String cEmerContactAddy) {
        this.cEmerContactAddy = cEmerContactAddy;
    }

    public String getcEmerContactCity() {
        return cEmerContactCity;
    }

    public void setcEmerContactCity(String cEmerContactCity) {
        this.cEmerContactCity = cEmerContactCity;
    }

    public String getcEmerContactbState() {
        return cEmerContactbState;
    }

    public void setcEmerContactbState(String cEmerContactbState) {
        this.cEmerContactbState = cEmerContactbState;
    }*/

    public String getdMaritalStatus() {
        return dMaritalStatus;
    }

    public void setdMaritalStatus(String dMaritalStatus) {
        this.dMaritalStatus = dMaritalStatus;
    }

    public String getdfamilyStatus() {
        return dfamilyStatus;
    }

    public void setdfamilyStatus(String dfamilyStatus) {
        this.dfamilyStatus = dfamilyStatus;
    }

    public String getdTotalInHouse() {
        return dTotalInHouse;
    }

    public void setdTotalInHouse(String dTotalInHouse) {
        this.dTotalInHouse = dTotalInHouse;
    }

    public String getdDepUnderFive() {
        return dDepUnderFive;
    }

    public void setdDepUnderFive(String dDepUnderFive) {
        this.dDepUnderFive = dDepUnderFive;
    }

    public String getdDepOverFive() {
        return dDepOverFive;
    }

    public void setdDepOverFive(String dDepOverFive) {
        this.dDepOverFive = dDepOverFive;
    }

    public String getdDepOverEighteen() {
        return dDepOverEighteen;
    }

    public void setdDepOverEighteen(String dDepOverEighteen) {
        this.dDepOverEighteen = dDepOverEighteen;
    }

    public boolean iseDrugTest() {
        return eDrugTest;
    }

    public void seteDrugTest(boolean eDrugTest) {
        this.eDrugTest = eDrugTest;
    }

    public boolean iseTanf() {
        return eTanf;
    }

    public void seteTanf(boolean eTanf) {
        this.eTanf = eTanf;
    }

    public boolean iseSnap() {
        return eSnap;
    }

    public void seteSnap(boolean eSnap) {
        this.eSnap = eSnap;
    }

    public boolean iseSsh() {
        return eSsh;
    }

    public void seteSsh(boolean eSsh) {
        this.eSsh = eSsh;
    }

    public boolean iseSsi() {
        return eSsi;
    }

    public void seteSsi(boolean eSsi) {
        this.eSsi = eSsi;
    }

    public boolean iseSsdi() {
        return eSsdi;
    }

    public void seteSsdi(boolean eSsdi) {
        this.eSsdi = eSsdi;
    }

    public boolean iseWic() {
        return eWic;
    }

    public void seteWic(boolean eWic) {
        this.eWic = eWic;
    }

    public boolean iseUnemp() {
        return eUnemp;
    }

    public void seteUnemp(boolean eUnemp) {
        this.eUnemp = eUnemp;
    }

    public boolean iseFelConvict() {
        return eFelConvict;
    }

    public void seteFelConvict(boolean eFelConvict) {
        this.eFelConvict = eFelConvict;
    }

    public String geteFcExplanation() {
        return eFcExplanation;
    }

    public void seteFcExplanation(String eFcExplanation) {
        this.eFcExplanation = eFcExplanation;
    }

    public String geteDisability() {
        return eDisability;
    }

    public void seteDisability(String eDisability) {
        this.eDisability = eDisability;
    }

    public String geteDisExplanation() {
        return eDisExplanation;
    }

    public void seteDisExplanation(String eDisExplanation) {
        this.eDisExplanation = eDisExplanation;
    }


    public String getDfamilyStatus() {
        return dfamilyStatus;
    }

    public void setDfamilyStatus(String dfamilyStatus) {
        this.dfamilyStatus = dfamilyStatus;
    }

    public String geteMilitarySrv() {
        return eMilitarySrv;
    }

    public void seteMilitarySrv(String eMilitarySrv) {
        this.eMilitarySrv = eMilitarySrv;
    }

    public boolean iseMilSpouse() {
        return eMilSpouse;
    }

    public void seteMilSpouse(boolean eMilSpouse) {
        this.eMilSpouse = eMilSpouse;
    }

    public String geteReferralSrc() {
        return eReferralSrc;
    }

    public void seteReferralSrc(String eReferralSrc) {
        this.eReferralSrc = eReferralSrc;
    }

    public String getfEmpId() {
        return fEmpId;
    }

    public void setfEmpId(String fEmpId) {
        this.fEmpId = fEmpId;
    }

    public Long getfGainEng() {
        return fGainEng;
    }

    public void setfGainEng(Long fGainEng) {
        this.fGainEng = fGainEng;
    }

    public Long getfGainMath() {
        return fGainMath;
    }

    public void setfGainMath(Long fGainMath) {
        this.fGainMath = fGainMath;
    }

    public String getfDistrict() {
        return fDistrict;
    }

    public void setfDistrict(String fDistrict) {
        this.fDistrict = fDistrict;
    }

    public String getfPrecinct() {
        return fPrecinct;
    }

    public void setfPrecinct(String fPrecinct) {
        this.fPrecinct = fPrecinct;
    }

    public Long getfCensus() {
        return fCensus;
    }

    public void setfCensus(Long fCensus) {
        this.fCensus = fCensus;
    }

    public Date getfDateComp() {
        return fDateComp;
    }

    public void setfDateComp(Date fDateComp) {
        this.fDateComp = fDateComp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
