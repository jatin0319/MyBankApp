package models;

import io.ebean.Finder;

import javax.persistence.*;

@Entity(name= "send_money")
public class SendMoney
{
    @OneToOne
    @JoinColumn(name= "trans_id",referencedColumnName = "trans_id" )
    private TransactionHist moneyId;

    @Column(name="acc_no")
    private String accountNo;

    @Column(name="ifsc ")
    private String ifsc;

    @Column(name="amount")
    private String amount;

    public TransactionHist getMoneyId() {
        return moneyId;
    }

    public void setMoneyId(TransactionHist moneyId) {
        this.moneyId = moneyId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }


    public static final Finder<Integer, SendMoney> find = new Finder<>(SendMoney.class);





}