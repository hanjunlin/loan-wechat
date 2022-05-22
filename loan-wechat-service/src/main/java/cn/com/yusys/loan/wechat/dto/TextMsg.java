package cn.com.yusys.loan.wechat.dto;

import java.io.Serializable;

/**
 * @author ：hanjl
 * @date ：Created in 2022/5/21 0021 21:14
 * @description：
 */
public class TextMsg implements Serializable {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
