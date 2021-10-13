package models;

import io.ebean.Finder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "transaction_type")

public class TransactionType {

    @Id
    @Column(name = "trans_id")
    private Integer id;

    @Column(name="trans_name")
    private String transName;

    public enum transactionTypeEnum
    {
        CREDIT(1),DEBIT(2);

        private Integer transId;

        public Integer getTransId() {
            return this.transId;
        }

        transactionTypeEnum(Integer id)
        {
            this.transId =id;
        }
    }

    public static TransactionType getInstance(Integer transId)
    {
        TransactionType transactionType=new TransactionType();
        transactionType.setId(transId);
        return transactionType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransName() {
        return transName;
    }

    public void setTransName(String transName) {
        this.transName = transName;
    }



    public static final Finder<Integer, TransactionType> find = new Finder<>(TransactionType.class);



}
