package com.insigma.sqlsync.configuration;

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
