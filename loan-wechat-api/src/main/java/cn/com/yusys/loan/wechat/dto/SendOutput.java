package cn.com.yusys.loan.wechat.dto;

import java.io.Serializable;

/**
 * @author ：hanjl
 * @date ：Created in 2022/5/21 0021 19:55
 * @description：
 */
public class SendOutput implements Serializable {

    private String errcode;

    private String errmsg;

    private String msgid;

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

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

}
