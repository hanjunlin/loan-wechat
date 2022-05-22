package cn.com.yusys.loan.wechat.config;

import cn.com.yusys.loan.wechat.component.WeChatComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：hanjl
 * @date ：Created in 2022/5/21 0021 20:44
 * @description：
 */
@Configuration
@Slf4j
public class AppConfig {

    @Value("${app.wechat.corpid}")
    private String corpid;

    @Value("${app.wechat.corpsecret}")
    private String corpsecret;

    @Bean
    public WeChatComponent weChatComponent() {
        log.info("创建WeChatComponent......");
        return new WeChatComponent(corpid, corpsecret);
    }

}
