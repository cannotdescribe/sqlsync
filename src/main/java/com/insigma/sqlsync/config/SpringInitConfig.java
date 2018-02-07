package com.insigma.sqlsync.config;

import com.insigma.sqlsync.spring.init.CommonRockInitializeBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Order(9999)
public class SpringInitConfig {
    @Bean
    public CommonRockInitializeBean springInitializeBean(){
        return new CommonRockInitializeBean();
    }
}
