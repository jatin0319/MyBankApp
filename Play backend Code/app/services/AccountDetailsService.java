package services;

import dto.UserSearchRequestDto;
import dto.UserSearchResponseDto;
import models.UserDetails;
import models.UserPassword;

public class AccountDetailsService {
    public static UserSearchResponseDto renderDetails(UserSearchRequestDto accountDetailsRequestDto)
    {
        UserSearchResponseDto accountDetailsResponseDto=new UserSearchResponseDto();

        try
        {
            UserDetails userDetails=UserDetails.find.byId(accountDetailsRequestDto.getUserId());

            UserPassword userPassword=UserPassword.find.query().where()
                    .eq("userId.id",userDetails.getId()).findOne();

            accountDetailsResponseDto.setfName(userDetails.getfName());
            accountDetailsResponseDto.setlName(userDetails.getlName());
            accountDetailsResponseDto.setEmail(userDetails.getEmail());
            accountDetailsResponseDto.setAddress(userDetails.getAddress());
            accountDetailsResponseDto.setDob(userDetails.getDob().toString());
            accountDetailsResponseDto.setMobileNo(userDetails.getMobileNo());
            accountDetailsResponseDto.setCreatedOn(userPassword.getCreatedOn().toDate().toString());
            accountDetailsResponseDto.setAdhaarNo(userDetails.getAdhaarNo());
            accountDetailsResponseDto.setPanNo(userDetails.getPanNo());
            accountDetailsResponseDto.setStatusID(userDetails.getStatusId().getStatusName());
            accountDetailsResponseDto.setBalance(userDetails.getBalance());

            accountDetailsResponseDto.setStatusCode(200);
            accountDetailsResponseDto.setStatusMsg("Profile Details Rendered");

        }

        catch(Exception exception)
        {
            accountDetailsResponseDto.setStatusCode(500);
            accountDetailsResponseDto.setStatusMsg("Some Error: "+ exception);
            return accountDetailsResponseDto;
        }

        return accountDetailsResponseDto;
    }
}
