package com.bao.hong.common.config;

import com.bao.hong.service.K2Pool;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(K2PoolProperties.class)
public class K2PoolAutoConfiguration {


    @Bean
    public K2Pool k2Pool() {
        return new K2Pool();
    }
}