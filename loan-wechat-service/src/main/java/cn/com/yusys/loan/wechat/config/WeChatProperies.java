package cn.com.yusys.loan.wechat.config;

import cn.com.yusys.loan.wechat.dto.UserExt;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author ：hanjl
 * @date ：Created in 2022/5/22 0022 16:54
 * @description：
 */
@Configuration
@ConfigurationProperties(prefix = "app.wechat")
@Data
public class WeChatProperies {

    private Map<String, UserExt> userExtMap;

}
