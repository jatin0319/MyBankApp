package dao;

import models.SendMoney;

public class SendMoneyDao {
    public static void saveSendMoneyDetails(SendMoney sendMoney)
    {
        DbConnector.save(sendMoney);
    }
}
