package cn.com.yusys.loan.wechat.dto;

import java.io.Serializable;

/**
 * @author ：hanjl
 * @date ：Created in 2022/5/21 0021 19:47
 * @description：
 */
public class TokenOutput implements Serializable {

    private String errcode;

    private String errmsg;

    private String accessToken;

    private Long expiresIn;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

}
