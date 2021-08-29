package com.bigboss.controller;


import com.bigboss.entity.Customer;
import com.bigboss.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author bigboss
 * @since 2021-08-04
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @RequestMapping(value = "/query")
    public List<Customer> list() {
        return  iCustomerService.list();
    }
}

