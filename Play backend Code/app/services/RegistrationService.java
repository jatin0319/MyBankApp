package services;


import dao.PasswordDao;
import dao.UserDao;
import dto.RegisterationResponseDto;
import dto.RegisterationRequestDto;
import io.ebean.DuplicateKeyException;
import models.AccountStatus;
import models.UserDetails;
import models.UserPassword;
import models.UserRole;
import org.joda.time.DateTime;

import java.util.regex.Pattern;


public class RegistrationService {

    public static RegisterationResponseDto save(RegisterationRequestDto requestDto) {
        RegisterationResponseDto registerationResponseDto = new RegisterationResponseDto();

        try {
            if (requestDto.getCnfrmPswrd().equals(requestDto.getPswrd())) {
                UserDetails user = new UserDetails();

                boolean fname = Pattern.matches("^[a-zA-Z\\\\s]*$", requestDto.getfName());
                if (!fname) {
                    registerationResponseDto.setStatusCode(400);
                    registerationResponseDto.setStatusMsg("Firstname only contains letters ");
                    return registerationResponseDto;
                }
                user.setfName(requestDto.getfName());


                boolean lname = Pattern.matches("^[a-zA-Z\\\\s]*$", requestDto.getlName());
                if (!lname) {
                    registerationResponseDto.setStatusCode(400);
                    registerationResponseDto.setStatusMsg("Lastname only contains letters ");
                    return registerationResponseDto;
                }
                user.setlName(requestDto.getlName());

                user.setDob(requestDto.getDob());
                user.setEmail(requestDto.getEmail());

                boolean mobile = Pattern.matches("[0-9]{10}", requestDto.getMobileNo());
                if (!mobile) {
                    registerationResponseDto.setStatusCode(400);
                    registerationResponseDto.setStatusMsg("Mobile Number format did not match");
                    return registerationResponseDto;
                }
                user.setMobileNo(requestDto.getMobileNo());

                boolean pan = Pattern.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}", requestDto.getPanNo());
                if (!pan) {
                    registerationResponseDto.setStatusCode(400);
                    registerationResponseDto.setStatusMsg("PAN Number format did not match");
                    return registerationResponseDto;
                }
                user.setPanNo(requestDto.getPanNo());

                boolean adhaar = Pattern.matches("[0-9]{12}", requestDto.getAdhaarNo());
                if (!adhaar) {
                    registerationResponseDto.setStatusCode(400);
                    registerationResponseDto.setStatusMsg("Adhaar Number format did not match");
                    return registerationResponseDto;
                }
                user.setAdhaarNo(requestDto.getAdhaarNo());
                user.setAddress(requestDto.getAddress());

                if (Integer.parseInt(requestDto.getBalance()) < 3000) {
                    registerationResponseDto.setStatusCode(400);
                    registerationResponseDto.setStatusMsg("Minimum amount is 3000 rupees");
                    return registerationResponseDto;
                }
                user.setBalance(requestDto.getBalance());

                user.setStatusId(AccountStatus.getInstance(AccountStatus.statusEnum.ACTIVE.getId()));
                user.setRoleId(UserRole.getInstance(UserRole.userRoleEnum.CUSTOMER.getRoleId()));

                UserPassword userpassword = new UserPassword();
                userpassword.setPasswrd(requestDto.getPswrd());
                userpassword.setCreatedOn(new DateTime());
                userpassword.setUserid(user);

                UserDao.saveUser(user);
                PasswordDao.savePassword(userpassword);
                registerationResponseDto.setStatusCode(201);
                registerationResponseDto.setStatusMsg("User Registered");
                return registerationResponseDto;
            }
              else {
                registerationResponseDto.setStatusCode(404);
                registerationResponseDto.setStatusMsg("Your password did not match");
            }
        }

         catch (DuplicateKeyException duplicateKeyException) {
            registerationResponseDto.setStatusCode(500);
            registerationResponseDto.setStatusMsg("Pan or Adhaar number already registered");
            return registerationResponseDto;
        }

         catch (Exception exception) {
            System.out.println("" + exception);
            registerationResponseDto.setStatusCode(500);
            registerationResponseDto.setStatusMsg("Internal server error" );
            return registerationResponseDto;
        }

        return registerationResponseDto;
    }
}
