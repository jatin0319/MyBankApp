package dao;

import models.TransactionHist;

public class TransactionHistoryDao {
    public static void saveTransactionHistoryDetails(TransactionHist transactionHist)
    {
        DbConnector.save(transactionHist);
    }
}
