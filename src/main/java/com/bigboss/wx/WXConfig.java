package com.bigboss.wx;

import lombok.Data;

/**
 * 微信配置文件
 */
@Data
public class WXConfig {

    /**
     * 小程序appId
     */
    private String appId;

    /**
     * 小程序secret
     */
    private String secret;
}
