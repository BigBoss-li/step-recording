package com.bigboss.config;

import com.bigboss.service.WxService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WxConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "wx")
    public WxConfig wxConfig() {
        return new WxConfig();
    }

    @Bean
    public WxService wxService(WxConfig wxConfig) {
        return new WxService(wxConfig);
    }
}
