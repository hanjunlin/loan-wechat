package cn.com.yusys.loan.wechat.dto;

/**
 * @author ：hanjl
 * @date ：Created in 2022/5/22 0022 14:47
 * @description：
 */
public class UserExt extends UserInfo {

    private int agentid;

    private String toparty;

    public int getAgentid() {
        return agentid;
    }

    public void setAgentid(int agentid) {
        this.agentid = agentid;
    }

    public String getToparty() {
        return toparty;
    }

    public void setToparty(String toparty) {
        this.toparty = toparty;
    }

}
