package services;

import dao.ActivateDeactivateDao;
import dto.DeactivateButtonRequestDto;
import dto.DeactivateButtonResponseDto;
import models.AccountStatus;
import models.UserDetails;
import models.UserRole;

public class DeactivateButtonService {

    public static DeactivateButtonResponseDto deactivateButton(DeactivateButtonRequestDto deactivateButtonRequestDto)
    {
        DeactivateButtonResponseDto deactivateButtonResponseDto=new DeactivateButtonResponseDto();

        try {
            UserDetails userDetails = UserDetails.find.byId(deactivateButtonRequestDto.getUserId());
            if (userDetails.getRoleId().getId().equals(UserRole.userRoleEnum.CUSTOMER.getRoleId())) {
                if (userDetails.getStatusId().getId().equals(AccountStatus.statusEnum.INACTIVE.getId())) {
                    deactivateButtonResponseDto.setStatusCode(400);
                    deactivateButtonResponseDto.setStatusMsg("This User Account is already inactive ");
                    return deactivateButtonResponseDto;
                }
                userDetails.setStatusId(AccountStatus.getInstance(AccountStatus.statusEnum.INACTIVE.getId()));
                deactivateButtonResponseDto.setStatusCode(200);
                deactivateButtonResponseDto.setStatusMsg("User Successfully Deactivated ");
                ActivateDeactivateDao.activateDeactivateUser(userDetails);
                return deactivateButtonResponseDto;
            }

        }

        catch(Exception exception)
        {
            deactivateButtonResponseDto.setStatusCode(500);
            deactivateButtonResponseDto.setStatusMsg("Server Error ");
            return deactivateButtonResponseDto;
        }
        deactivateButtonResponseDto.setStatusCode(400);
        deactivateButtonResponseDto.setStatusMsg("No customer Account Found");
        return deactivateButtonResponseDto;
    }
}
