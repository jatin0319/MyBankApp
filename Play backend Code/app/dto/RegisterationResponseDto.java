package dto;

public class RegisterationResponseDto {

    private Integer statusCode;
    private String statusMsg;


    public Integer getStatusCode() {
        return statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;


    }

}

