package com.bigboss.service.impl;

import com.bigboss.entity.Customer;
import com.bigboss.mapper.CustomerMapper;
import com.bigboss.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
