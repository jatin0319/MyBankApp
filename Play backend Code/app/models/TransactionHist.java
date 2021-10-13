package models;

import io.ebean.Finder;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity(name="transaction_hist")

public class TransactionHist {

    @Id
    @Column(name = "trans_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private UserDetails userId;

    @Column(name = "trans_desc")
    private String transDesc;

    @Column(name = "date_time")
    private DateTime dateTime;

    @Column(name= "amount")
    private String amount ;

    @OneToOne
    @JoinColumn(name ="trans_type" ,referencedColumnName = "trans_id" )
    private TransactionType transType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDetails getUserId() {
        return userId;
    }

    public void setUserId(UserDetails userId) {
        this.userId = userId;
    }

    public String getTransDesc() {
        return transDesc;
    }

    public void setTransDesc(String transDesc) {
        this.transDesc = transDesc;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public TransactionType getTransType() {
        return transType;
    }

    public void setTransType(TransactionType transType) {
        this.transType = transType;
    }

    public static final Finder<Integer, TransactionHist> find = new Finder<>(TransactionHist.class);

}