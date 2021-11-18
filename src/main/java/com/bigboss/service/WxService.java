package com.bigboss.service;

import com.alibaba.fastjson.JSONObject;
import com.bigboss.utils.WebClientUtils;
import com.bigboss.wx.WXConfig;
import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

public class WxService {

    private static final String WX_LOGIN = "https://api.weixin.qq.com/sns/jscode2session";

    private final WXConfig wxConfig;

    public WxService(WXConfig wxConfig) {
        this.wxConfig = wxConfig;
    }

    /**
     * 小程序登录凭证校验
     *
     * @param code 从小程序端传来的code
     */
    public JSONObject login(String code) {
        Map<String, String> params = new HashMap<>(4);
        params.put("appid", wxConfig.getAppId());
        params.put("secret", wxConfig.getSecret());
        params.put("js_code", code);
        params.put("grant_type", "authorization_code");
        return WebClientUtils.doHttpRequest(WX_LOGIN, params, JSONObject.class, HttpMethod.GET);
    }
}
