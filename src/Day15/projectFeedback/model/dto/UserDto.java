package Day15.projectFeedback.model.dto;

public class UserDto {
    private int uNo;
    private String uId;
    private String uPwd;
    private String uName;
    private String uPhone;

    public UserDto() {

    }
    public UserDto(int uNo, String uId, String uPwd, String uName, String uPhone) {
        this.uNo = uNo;
        this.uId = uId;
        this.uPwd = uPwd;
        this.uName = uName;
        this.uPhone = uPhone;
    }

    public int getuNo() { return uNo; }
    public void setuNo(int uNo) { this.uNo = uNo; }

    public String getuId() { return uId; }
    public void setuId(String uId) { this.uId = uId; }

    public String getuPwd() { return uPwd; }
    public void setuPwd(String uPwd) { this.uPwd = uPwd; }

    public String getuName() { return uName; }
    public void setuName(String uName) { this.uName = uName; }

    public String getuPhone() { return uPhone; }
    public void setuPhone(String uPhone) { this.uPhone = uPhone; }

    @Override
    public String toString() {
        return "UserDto{" +
                "uNo=" + uNo +
                ", uId='" + uId + '\'' +
                ", uPwd='" + uPwd + '\'' +
                ", uName='" + uName + '\'' +
                ", uPhone='" + uPhone + '\'' +
                '}';
    }
} // class end
