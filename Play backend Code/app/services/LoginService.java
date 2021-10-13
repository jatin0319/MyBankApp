package services;

import dto.LoginRequestDto;
import dto.LoginResponseDto;
import models.AccountStatus;
import models.UserDetails;
import models.UserPassword;

public class LoginService {
    public static LoginResponseDto validationCredentials(LoginRequestDto loginRequestDto)
    {
        LoginResponseDto loginResponseDto=new LoginResponseDto();

        try {
            UserDetails userDetails = UserDetails.find.byId(Integer.parseInt(loginRequestDto.getUserId()));
            if (userDetails == null) {
                loginResponseDto.setStatusCode(400);
                loginResponseDto.setStatusMsg("Invalid User Id");
                return loginResponseDto;
            }
            UserPassword userPassword = UserPassword.find.query().where()
                    .eq("userId.id", userDetails.getId())
                    .eq("passwrd", loginRequestDto.getPswrd()).findOne();

            if(userPassword==null){
                loginResponseDto.setStatusCode(404);
                loginResponseDto.setStatusMsg("Wrong Password");
                return loginResponseDto;
            }

            if(userDetails.getStatusId().getId().equals(AccountStatus.statusEnum.INACTIVE.getId())) {
                loginResponseDto.setStatusCode(400);
                loginResponseDto.setStatusMsg("Inactive Account.... Contact Admin ");
                return loginResponseDto;
            }

            if(userDetails.getStatusId().getId().equals(AccountStatus.statusEnum.ACTIVE.getId())) {
            loginResponseDto.setStatusCode(200);
            loginResponseDto.setStatusMsg("Successful Login");
            loginResponseDto.setStatusId(userDetails.getStatusId().getStatusName());
            loginResponseDto.setRoleId(userDetails.getRoleId().getRoleName());
           }
        }

        catch (NumberFormatException numberFormatException)
        {
            System.out.println("Some Exception"+numberFormatException);
            loginResponseDto.setStatusCode(500);
            loginResponseDto.setStatusMsg("Enter user Id properly");
            return loginResponseDto;
        }

          catch (Exception exception)
        {
            System.out.println("Some Exception"+exception);
            loginResponseDto.setStatusCode(500);
            loginResponseDto.setStatusMsg("Internal Server Error");
            return loginResponseDto;
        }

        return loginResponseDto;
    }
}
