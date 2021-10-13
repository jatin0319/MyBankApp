package services;
import dto.ViewListResponseDto;
import models.UserDetails;
import models.UserPassword;
import models.UserRole;


import java.util.ArrayList;
import java.util.List;

public class ViewListService {
    public static List<ViewListResponseDto> listOfCustomers()
    {
        List<ViewListResponseDto> viewListResponseDtoList=new ArrayList<ViewListResponseDto>();

        try
        {
          List<UserDetails> userDetailsList =UserDetails.find.query().where()
                  .eq("roleId.id", UserRole.userRoleEnum.CUSTOMER.getRoleId()).findList();

          if(userDetailsList.size()==0)
          {
              ViewListResponseDto viewListResponseDto=new ViewListResponseDto();
              viewListResponseDto.setStatusCode(400);
              viewListResponseDto.setStatusMsg("No List Found");
              viewListResponseDtoList.add(viewListResponseDto);
              return viewListResponseDtoList;
          }

          for(UserDetails  userDetails:userDetailsList)
          {
              UserPassword userPassword=UserPassword.find.query().where()
                      .eq("userId.id",userDetails.getId()).findOne();

              ViewListResponseDto viewListResponseDto=new ViewListResponseDto();
             viewListResponseDto.setUserId(userDetails.getId());
             viewListResponseDto.setfName(userDetails.getfName());
             viewListResponseDto.setlName(userDetails.getlName());
             viewListResponseDto.setDob(userDetails.getDob().toString());
             viewListResponseDto.setAddress(userDetails.getAddress());
             viewListResponseDto.setStatusId(userDetails.getStatusId().getStatusName());
             viewListResponseDto.setAdhaarNo(userDetails.getAdhaarNo());
             viewListResponseDto.setEmail(userDetails.getEmail());
             viewListResponseDto.setMobileNo(userDetails.getMobileNo());
             viewListResponseDto.setPanNo(userDetails.getPanNo());
             viewListResponseDto.setBalance(userDetails.getBalance());

             assert userPassword != null;
             viewListResponseDto.setCreatedOn(userPassword.getCreatedOn().toString());
             viewListResponseDto.setStatusCode(200);
             viewListResponseDto.setStatusMsg("Customer List Rendered");
             viewListResponseDtoList.add(viewListResponseDto);
          }
        }

        catch (Exception exception)
        {
            ViewListResponseDto viewListResponseDto=new ViewListResponseDto();
            viewListResponseDto.setStatusCode(500);
            viewListResponseDto.setStatusMsg("Error"+ exception);
            viewListResponseDtoList.add(viewListResponseDto);
        return viewListResponseDtoList;
        }

        return viewListResponseDtoList;
    }

}
