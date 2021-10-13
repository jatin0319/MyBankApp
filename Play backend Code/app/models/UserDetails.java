package models;

import io.ebean.Finder;

import javax.persistence.*;
import java.util.Date;
@Entity(name="user_details")

public class UserDetails
{
    @Id
    @Column(name = "user_id")
    private Integer id;

    @Column(name= "fname")
    private String fName;

    @Column(name= "lname")
    private String lName;

    @ManyToOne
    @JoinColumn(name= "role_id",referencedColumnName = "role_id")
    private UserRole roleId;

    @Column(name= "dob")
    private Date dob;

    @Column(name= "pan_no")
    private String panNo;

    @Column(name= "adhaar_no")
    private String adhaarNo;

    @Column(name= "address")
    private String address;

    @Column(name= "email")
    private String email;

    @Column(name = "mobile_no")
    private String mobileNo;

    @ManyToOne
    @JoinColumn(name= "status_id",referencedColumnName = "status_id")
    private AccountStatus statusId;

    @Column(name = "Balance")
    private String balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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


    public UserRole getRoleId() {
        return roleId;
    }

    public void setRoleId(UserRole roleId) {
        this.roleId = roleId;
    }

    public AccountStatus getStatusId() {
        return statusId;
    }

    public void setStatusId(AccountStatus statusId) {
        this.statusId = statusId;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public static final Finder<Integer, UserDetails> find = new Finder<>(UserDetails.class);



}
