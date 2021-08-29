package com.bigboss.service;

import com.bigboss.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bigboss
 * @since 2021-08-04
 */
public interface ICustomerService extends IService<Customer>, UserDetailsService {

}
