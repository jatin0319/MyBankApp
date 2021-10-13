package services;

import dto.TransactionHistoryRequestDto;
import dto.TransactionHistoryResponseDto;
import models.TransactionHist;
import models.UserDetails;

import java.util.ArrayList;
import java.util.List;

public class TransactionHistoryService {

    public static List<TransactionHistoryResponseDto> listOfCustomers(TransactionHistoryRequestDto transactionHistoryRequestDto)
    {
        List<TransactionHistoryResponseDto> transactionHistoryResponseDtoList = new ArrayList<>();
     try
     {
         UserDetails userDetails=UserDetails.find.byId(transactionHistoryRequestDto.getUserId());
         List<TransactionHist>transactionHistList = TransactionHist.find.query()
                 .where().eq("userId.id",transactionHistoryRequestDto.getUserId()).findList();

         if(transactionHistList.size()==0)
         {
             TransactionHistoryResponseDto transactionHistoryResponseDto=new TransactionHistoryResponseDto();
             transactionHistoryResponseDto.setStatusCode(400);
             transactionHistoryResponseDto.setStatusMsg("N0 Transaction Present");
             transactionHistoryResponseDtoList.add(transactionHistoryResponseDto);
             return transactionHistoryResponseDtoList;
         }

         for(TransactionHist transactionHist : transactionHistList )
         {
             TransactionHistoryResponseDto transactionHistoryResponseDto=new TransactionHistoryResponseDto();
             transactionHistoryResponseDto.setTransId(transactionHist.getId());
             transactionHistoryResponseDto.setDateTime(transactionHist.getDateTime().toString());
             transactionHistoryResponseDto.setTransactionType(transactionHist.getTransType().getTransName());
             transactionHistoryResponseDto.setAmount(transactionHist.getAmount());
             transactionHistoryResponseDto.setDescription(transactionHist.getTransDesc());
             transactionHistoryResponseDto.setStatusCode(200);
             transactionHistoryResponseDto.setStatusMsg("Transaction History Rendered");

             transactionHistoryResponseDtoList.add(transactionHistoryResponseDto);
         }

     }

     catch (Exception exception)
     {
         TransactionHistoryResponseDto transactionHistoryResponseDto=new TransactionHistoryResponseDto();
         transactionHistoryResponseDto.setStatusCode(500);
         transactionHistoryResponseDto.setStatusMsg("Error:"+ exception);
         transactionHistoryResponseDtoList.add(transactionHistoryResponseDto);

        return transactionHistoryResponseDtoList;
     }

       return transactionHistoryResponseDtoList;
    }
}
