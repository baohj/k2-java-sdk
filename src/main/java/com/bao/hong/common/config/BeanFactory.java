package com.bao.hong.common.config;

import com.bao.hong.common.util.RSAUtil;
import com.bao.hong.service.K2Pool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(K2PoolConfig.class)
public class BeanFactory {

    @Autowired
    private K2PoolConfig k2PoolProperties;

    @Bean
    public K2Pool k2Pool() {
        RSAUtil.setK2PoolConfig(k2PoolProperties);
        return new K2Pool();
    }

}