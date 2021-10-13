package services;

import dao.ActivateDeactivateDao;
import dto.ActivateButtonRequestDto;
import dto.ActivateButtonResponseDto;
import models.AccountStatus;
import models.UserDetails;
import models.UserRole;

public class ActivateButtonService {

    public static ActivateButtonResponseDto userActive(ActivateButtonRequestDto activateButtonRequestDto)
    {
        ActivateButtonResponseDto activateButtonResponseDto=new ActivateButtonResponseDto();

        try
        {
            UserDetails userDetails= UserDetails.find.query().
                            where().eq("id",activateButtonRequestDto.getUserId())
                    .eq("roleId.id", UserRole.userRoleEnum.CUSTOMER.getRoleId()).findOne();

            if(userDetails==null)
            {
                activateButtonResponseDto.setStatusCode(400);
                activateButtonResponseDto.setStatusMsg("Enter correct customer Id");
                return activateButtonResponseDto;
            }

            if(userDetails.getStatusId().getId().equals(AccountStatus.statusEnum.INACTIVE.getId()))
            {
                userDetails.setStatusId(AccountStatus.getInstance(AccountStatus.statusEnum.ACTIVE.getId()));
                ActivateDeactivateDao.activateDeactivateUser(userDetails);
                activateButtonResponseDto.setStatusCode(200);
                activateButtonResponseDto.setStatusMsg("Customer is successfully Activated");
                return activateButtonResponseDto;
            }


        }
         catch (Exception exception)
         {
             activateButtonResponseDto.setStatusCode(500);
             activateButtonResponseDto.setStatusMsg("Internal Server Error");
             return activateButtonResponseDto;

         }

        activateButtonResponseDto.setStatusCode(400);
        activateButtonResponseDto.setStatusMsg("This customer is already active");
        return activateButtonResponseDto;
    }
}
