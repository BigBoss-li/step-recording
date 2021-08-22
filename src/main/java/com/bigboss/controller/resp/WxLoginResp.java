package com.bigboss.controller.resp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class WxLoginResp {

    @JSONField(name = "openid")
    private String openId;

    @JSONField(name = "session_key")
    private String sessionKey;

    @JSONField(name = "unionid")
    private String unionId;

    @JSONField(name = "errcode")
    private Integer errCode;

    @JSONField(name = "errmsg")
    private String errMsg;
}
