package com.bigboss.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.bigboss.mapper")
public class MybatisConfiguration {
}
