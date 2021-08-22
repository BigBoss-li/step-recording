package com.bigboss.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.mybatisplus.mapper")
public class MybatisConfiguration {
}
