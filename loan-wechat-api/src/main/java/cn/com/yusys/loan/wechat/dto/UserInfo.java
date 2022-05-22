package cn.com.yusys.loan.wechat.dto;

/**
 * @author ：hanjl
 * @date ：Created in 2022/5/22 0022 14:41
 * @description：
 */
public class UserInfo {

    private String userCode;

    private String password;

    private String token;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
