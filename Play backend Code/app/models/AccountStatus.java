package models;

import io.ebean.Finder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "acc_status")
public class AccountStatus {

    @Column(name = "status_name")
    private String statusName;

    @Id
    @Column(name = "status_id")
    private Integer id;


    public enum statusEnum
    {   ACTIVE(1),INACTIVE(2);

        private Integer statusId;

        public Integer getId()
        {
            return this.statusId;
        }

        statusEnum(Integer i)
        {
            this.statusId=i;
        }

    }
    public static AccountStatus getInstance(Integer statusId)
    {
        AccountStatus accountStatus=new AccountStatus();
        accountStatus.setId(statusId);
        return accountStatus;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public static final Finder<Integer, AccountStatus> find = new Finder<>(AccountStatus.class);


}
