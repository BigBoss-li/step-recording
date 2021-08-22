package com.bigboss.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.bigboss.controller.resp.WxLoginResp;
import com.bigboss.entity.Customer;
import com.bigboss.service.ICustomerService;
import com.bigboss.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/auth/token")
@RestController
public class AuthorizationController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private WxService wxService;

    @PostMapping(value = "/by-code")
    public String login(String code) {
        WxLoginResp wxLoginResp = JSONObject.toJavaObject(wxService.login(code), WxLoginResp.class);
        LambdaQueryWrapper<Customer> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Customer::getOpenId, wxLoginResp.getOpenId());
        Customer customer = customerService.getOne(lambdaQueryWrapper);
        return code;
    }
}
