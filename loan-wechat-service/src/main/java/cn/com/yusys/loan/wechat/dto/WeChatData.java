package cn.com.yusys.loan.wechat.dto;

/**
 * @author ：hanjl
 * @date ：Created in 2022/5/21 0021 20:01
 * @description：
 */
public class WeChatData {

    /**
     * 部门账号
     */
    private String toparty;

    /**
     * 消息类型
     */
    private String msgtype = "text";

    /**
     * 企业应用的agentID
     */
    private int agentid;

    /**
     * 实际接收Map类型数据
     */
    private TextMsg text = new TextMsg();

    public String getToparty() {
        return toparty;
    }

    public void setToparty(String toparty) {
        this.toparty = toparty;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public int getAgentid() {
        return agentid;
    }

    public void setAgentid(int agentid) {
        this.agentid = agentid;
    }

    public TextMsg getText() {
        return text;
    }

    public void setText(TextMsg text) {
        this.text = text;
    }

}
