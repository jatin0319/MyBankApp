package dto;


import play.data.validation.Constraints;

import java.util.Date;

public class RegisterationRequestDto {

    private String fName;

    private String lName;

    private Date dob;

    private String panNo;

    private String adhaarNo;

    private String address;

    private String email;

    private String mobileNo;

    private String Balance;

    private String pswrd;

    private String cnfrmPswrd;

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getAdhaarNo() {
        return adhaarNo;
    }

    public void setAdhaarNo(String adhaarNo) {
        this.adhaarNo = adhaarNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getBalance() {
        return Balance;
    }

    public void setBalance(String balance) {
        Balance = balance;
    }

    public String getPswrd() {
        return pswrd;
    }

    public void setPswrd(String pswrd) {
        this.pswrd = pswrd;
    }

    public String getCnfrmPswrd() {
        return cnfrmPswrd;
    }

    public void setCnfrmPswrd(String cnfrmPswrd) {
        this.cnfrmPswrd = cnfrmPswrd;
    }
}
