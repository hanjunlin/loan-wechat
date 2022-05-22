package cn.com.yusys.loan.wechat.component;

import cn.com.yusys.loan.wechat.dto.SendOutput;
import cn.com.yusys.loan.wechat.dto.TokenOutput;
import cn.com.yusys.loan.wechat.dto.WeChatData;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author ：hanjl
 * @date ：Created in 2022/5/21 0021 19:16
 * @description：
 */
@Slf4j
public class WeChatComponent {

    private final String tokenUrl = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?";

    private final String sendMessageUrl = "https://qyapi.weixin.qq.com/cgi-bin/message/send?";

    private String corpid;

    private String corpsecret;

    private String token;

    public WeChatComponent(String corpid, String corpsecret) {
        this.corpid = corpid;
        this.corpsecret = corpsecret;
    }

    public TokenOutput toAuth() throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(tokenUrl + "corpid=" + corpid + "&corpsecret=" + corpsecret);

        try (CloseableHttpResponse response = httpClient.execute(httpGet);) {
            HttpEntity entity = response.getEntity();
            String out = EntityUtils.toString(entity, "utf-8");
            EntityUtils.consume(entity);
            log.info("out:{}", out);
            TokenOutput tokenOutput = JSON.parseObject(out, TokenOutput.class);
            if (!"0".equals(tokenOutput.getErrcode())) {
                throw new Exception(tokenOutput.getErrmsg());
            }
            token = tokenOutput.getAccessToken();
            return tokenOutput;
        }
    }

    public SendOutput sendMsg(WeChatData weChatData) throws Exception {
        if (null == token) {
            toAuth();
        }
        String url = sendMessageUrl + "access_token=" + token;
        String json = JSON.toJSONString(weChatData);
        log.info("json:" + json);
        String out = HttpUtil.post(url, json);
        SendOutput sendOutput = JSON.parseObject(out, SendOutput.class);
        if ("42001".equals(sendOutput.getErrcode())) {
            //token过期
            toAuth();
            out = HttpUtil.post(url, json);
            sendOutput = JSON.parseObject(out, SendOutput.class);
        }
        return sendOutput;
    }

}
