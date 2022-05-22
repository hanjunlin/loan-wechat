package cn.com.yusys.loan.wechat.dto;

/**
 * @author ：hanjl
 * @date ：Created in 2022/5/22 0022 14:38
 * @description：
 */
public class WeChatMsg {

    private String userCode;

    private String accessToken;

    private String msg;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
