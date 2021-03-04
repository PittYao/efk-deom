package com.fanyao.elk.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: bugProvider
 * @date: 2021/3/3 14:18
 * @description:
 */
@Configuration
@MapperScan("com.fanyao.elk.dao.mapper")
public class MyBatisPlusConfig {

}
