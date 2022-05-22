package cn.com.yusys.loan.wechat.web.rest;

import cn.com.yusys.loan.wechat.constance.WeChatContance;
import cn.com.yusys.loan.wechat.dto.SendOutput;
import cn.com.yusys.loan.wechat.dto.TokenOutput;
import cn.com.yusys.loan.wechat.dto.UserInfo;
import cn.com.yusys.loan.wechat.dto.WeChatMsg;
import cn.com.yusys.loan.wechat.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：hanjl
 * @date ：Created in 2022/5/22 0022 17:19
 * @description：
 */
@RestController
public class WeChatController {

    @Autowired
    private WeChatService weChatService;

    @PostMapping(WeChatContance.ApplyTokenUrl)
    public TokenOutput applyToken(@RequestBody UserInfo userInfo) {
        return weChatService.applyToken(userInfo);
    }

    @PostMapping(WeChatContance.SendMsgUrl)
    public SendOutput sendMsg(@RequestBody WeChatMsg weChatMsg) throws Exception {
        return weChatService.sendMsg(weChatMsg);
    }

}
