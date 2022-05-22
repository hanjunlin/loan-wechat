package cn.com.yusys.loan.wechat.service;

import cn.com.yusys.loan.wechat.component.WeChatComponent;
import cn.com.yusys.loan.wechat.config.WeChatProperies;
import cn.com.yusys.loan.wechat.dto.*;
import cn.com.yusys.loan.wechat.util.TokenUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author ：hanjl
 * @date ：Created in 2022/5/21 0021 19:16
 * @description：
 */
@Service
@Slf4j
public class WeChatService {

    @Autowired
    private WeChatProperies weChatProperies;

    @Autowired
    private WeChatComponent weChatComponent;

    public TokenOutput applyToken(@RequestBody UserInfo userInfo) {
        TokenOutput tokenOutput = new TokenOutput();
        Map<String, UserExt> userExtMap = weChatProperies.getUserExtMap();
        UserExt userExt = userExtMap.get(userInfo.getUserCode());
        if (null == userExt || !userExt.getPassword().equals(userInfo.getPassword())) {
            tokenOutput.setErrcode("loan-0010");
            tokenOutput.setErrmsg("密码不正确或者用户代码不存在");
            return tokenOutput;
        }
        String token = TokenUtils.token(userInfo.getUserCode(), userInfo.getPassword());
        tokenOutput.setErrcode("0");
        tokenOutput.setAccessToken(token);
        tokenOutput.setExpiresIn(TokenUtils.EXPIRE_DATE);
        log.info("tokenOutput:" + JSON.toJSONString(tokenOutput));
        return tokenOutput;
    }

    public SendOutput sendMsg(@RequestBody WeChatMsg weChatMsg) throws Exception {
        SendOutput sendOutput ;
        if (!TokenUtils.verify(weChatMsg.getUserCode(), weChatMsg.getAccessToken())) {
            sendOutput = new SendOutput();
            sendOutput.setErrcode("loan-0020");
            sendOutput.setErrmsg("错误的token或者token已失效");
            return sendOutput;
        }
        Map<String, UserExt> userExtMap = weChatProperies.getUserExtMap();
        UserExt userExt = userExtMap.get(weChatMsg.getUserCode());
        if (null == userExt) {
            sendOutput = new SendOutput();
            sendOutput.setErrcode("loan-0030");
            sendOutput.setErrmsg("用户代码不存在");
            return sendOutput;
        }
        WeChatData weChatData = new WeChatData();
        weChatData.setToparty(userExt.getToparty());
        weChatData.setAgentid(userExt.getAgentid());
        weChatData.getText().setContent(weChatMsg.getMsg());
        sendOutput = weChatComponent.sendMsg(weChatData);
        log.info("sendOutput:" + JSON.toJSONString(sendOutput));
        return sendOutput;
    }

}
