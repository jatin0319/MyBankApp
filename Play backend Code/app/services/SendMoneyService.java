package services;

import dao.SendMoneyDao;
import dao.TransactionHistoryDao;
import dao.UserDao;
import dto.SendMoneyRequestDto;
import dto.SendMoneyResponseDto;
import models.SendMoney;
import models.TransactionHist;
import models.TransactionType;
import models.UserDetails;
import org.joda.time.DateTime;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SendMoneyService {

    public static SendMoneyResponseDto saveDetails(SendMoneyRequestDto sendMoneyRequestDto)
    {
        SendMoneyResponseDto sendMoneyResponseDto=new SendMoneyResponseDto();

        try
        {
            if(Integer.parseInt(sendMoneyRequestDto.getAmount())>0 && Integer.parseInt(sendMoneyRequestDto.getAmount())<10000 ) {
                UserDetails userDetails = UserDetails.find.byId(sendMoneyRequestDto.getUserId());
                SendMoney sendMoney = new SendMoney();
                TransactionHist transactionHist = new TransactionHist();

                transactionHist.setUserId(userDetails);

                boolean name = Pattern.matches("^[a-zA-Z\\\\s]*$", sendMoneyRequestDto.getRecieverName());
                if (!name) {
                    sendMoneyResponseDto.setStatusCode(400);
                    sendMoneyResponseDto.setStatusMsg("Name only contains letters");
                    return sendMoneyResponseDto;
                }

                transactionHist.setTransDesc(sendMoneyRequestDto.getRecieverName());
                transactionHist.setAmount(sendMoneyRequestDto.getAmount());
                transactionHist.setDateTime(new DateTime());
                transactionHist.setTransType(TransactionType.getInstance(TransactionType.transactionTypeEnum.DEBIT.getTransId()));


                boolean acc= Pattern.matches("[0-9]{16}",sendMoneyRequestDto.getAccountNumber());
                if (!acc) {
                    sendMoneyResponseDto.setStatusCode(400);
                    sendMoneyResponseDto.setStatusMsg("Account Number format did not match");
                    return sendMoneyResponseDto;
                }
                sendMoney.setAccountNo(sendMoneyRequestDto.getAccountNumber());

                boolean ifsc= Pattern.matches("[A-Z]{4}0[0-9]{6}",sendMoneyRequestDto.getIfsc());
                if (!ifsc) {
                    sendMoneyResponseDto.setStatusCode(400);
                    sendMoneyResponseDto.setStatusMsg("IFSC format did not match");
                    return sendMoneyResponseDto;
                }
                sendMoney.setIfsc(sendMoneyRequestDto.getIfsc());

                sendMoney.setMoneyId(transactionHist);
                sendMoney.setAmount(sendMoneyRequestDto.getAmount());


                int currentBalance = Integer.parseInt(userDetails.getBalance());
                int amount = Integer.parseInt(sendMoney.getAmount());
                int updatedBalance = currentBalance - amount;

                if(updatedBalance < 0)
                {
                    sendMoneyResponseDto.setStatusCode(400);
                    sendMoneyResponseDto.setStatusMsg("You have insufficient Balance");
                    return sendMoneyResponseDto;
                }

                userDetails.setBalance(Integer.toString(updatedBalance));
                UserDao.updateUser(userDetails);

                TransactionHistoryDao.saveTransactionHistoryDetails(transactionHist);
                SendMoneyDao.saveSendMoneyDetails(sendMoney);
                sendMoneyResponseDto.setStatusCode(200);
                sendMoneyResponseDto.setStatusMsg("Money Sent Successfully");
            }
            else
            {
                sendMoneyResponseDto.setStatusCode(400);
                sendMoneyResponseDto.setStatusMsg("Amount should be between 1 to 10,000");
            }
        }

        catch (Exception exception)
        {
            sendMoneyResponseDto.setStatusCode(500);
            sendMoneyResponseDto.setStatusMsg("Error :"+exception);
            return sendMoneyResponseDto;
        }


        return sendMoneyResponseDto;
    }
}
