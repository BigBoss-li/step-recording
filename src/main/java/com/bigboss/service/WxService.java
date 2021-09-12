package com.bigboss.service;

import com.alibaba.fastjson.JSONObject;
import com.bigboss.wx.WXConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class WxService {

    private static final String WX_LOGIN = "https://api.weixin.qq.com/sns/jscode2session?appid={1}&secret={2}" +
            "&js_code={3}&grant_type=authorization_code";

    private final WXConfig wxConfig;

    @Autowired
    private RestTemplate restTemplate;

    public WxService(WXConfig wxConfig) {
        this.wxConfig = wxConfig;
    }

    /**
     * 小程序登录凭证校验
     * @param code 从小程序端传来的code
     */
    public JSONObject login(String code) {
        return restTemplate.getForObject(WX_LOGIN, JSONObject.class, this.wxConfig.getAppId(),
               this.wxConfig.getSecret(), code);
    }
}
