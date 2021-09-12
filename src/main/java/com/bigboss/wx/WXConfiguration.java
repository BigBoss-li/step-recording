package com.bigboss.wx;

import com.bigboss.service.WxService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 微信配置
 */
@Configuration
public class WXConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "wx")
    public WXConfig wxConfig() {
        return new WXConfig();
    }

    @Bean
    public WxService wxService(WXConfig wxConfig) {
        return new WxService(wxConfig);
    }
}
