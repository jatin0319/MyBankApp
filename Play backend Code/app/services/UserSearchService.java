package services;

import dto.UserSearchRequestDto;
import dto.UserSearchResponseDto;
import models.UserDetails;
import models.UserPassword;
import models.UserRole;

public class UserSearchService {
    public static UserSearchResponseDto deactivateSearch(UserSearchRequestDto userSearchRequestDto)
    {
        UserSearchResponseDto userSearchResponseDto=new UserSearchResponseDto();

        try {
            UserDetails userDetails = UserDetails.find.byId(userSearchRequestDto.getUserId());

            if (userDetails == null) {
                userSearchResponseDto.setStatusCode(400);
                userSearchResponseDto.setStatusMsg("Customer ID Does not Exist");
                return userSearchResponseDto;
            }
            if (userDetails.getRoleId().getId()==UserRole.userRoleEnum.CUSTOMER.getRoleId()) {

                    UserPassword userPassword = UserPassword.find.query().where()
                            .eq("userId.id", userDetails.getId()).findOne();

                    userSearchResponseDto.setfName(userDetails.getfName());
                    userSearchResponseDto.setlName(userDetails.getlName());
                    userSearchResponseDto.setEmail(userDetails.getEmail());
                    userSearchResponseDto.setAddress(userDetails.getAddress());
                    userSearchResponseDto.setDob(userDetails.getDob().toString());
                    userSearchResponseDto.setMobileNo(userDetails.getMobileNo());
                    userSearchResponseDto.setCreatedOn(userPassword.getCreatedOn().toDate().toString());
                    userSearchResponseDto.setAdhaarNo(userDetails.getAdhaarNo());
                    userSearchResponseDto.setPanNo(userDetails.getPanNo());
                    userSearchResponseDto.setStatusID(userDetails.getStatusId().getStatusName());

                    userSearchResponseDto.setStatusCode(200);
                    userSearchResponseDto.setStatusMsg("Profile Details Rendered");
                    return userSearchResponseDto;
                }
        }

        catch(Exception exception)
        {
            userSearchResponseDto.setStatusCode(500);
            userSearchResponseDto.setStatusMsg("Error :"+exception);
            return userSearchResponseDto;
        }

        userSearchResponseDto.setStatusCode(400);
        userSearchResponseDto.setStatusMsg("No Active Customer Account Found");
        return userSearchResponseDto;
    }
}
