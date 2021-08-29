package com.bigboss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.bigboss.entity.Customer;
import com.bigboss.mapper.CustomerMapper;
import com.bigboss.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bigboss.utils.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bigboss
 * @since 2021-08-04
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    @Override
    public UserDetails loadUserByUsername(String openId) throws UsernameNotFoundException {
        LambdaQueryWrapper<Customer> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Customer::getOpenId, openId);
        Customer customer = this.getOne(lambdaQueryWrapper);
        return new User(customer.getId(), customer.getOpenId(), customer.getOpenId());
    }
}
