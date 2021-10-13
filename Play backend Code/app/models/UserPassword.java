package models;


import io.ebean.Finder;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity(name = "user_password")
public class UserPassword {

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private UserDetails userId;

    @Column(name = "passwrd")
    private String passwrd;

    @Column(name = "created_on")
    private DateTime createdOn;

    public UserDetails getUserid() {
        return userId;
    }

    public void setUserid(UserDetails userid) {
        this.userId = userid;
    }

    public String getPasswrd() {
        return passwrd;
    }

    public void setPasswrd(String passwrd) {
        this.passwrd = passwrd;
    }

    public DateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(DateTime createdOn) {
        this.createdOn = createdOn;
    }



    public static final Finder<Integer, UserPassword> find = new Finder<>(UserPassword.class);


}
