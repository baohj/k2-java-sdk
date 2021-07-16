package io.k2pool.common.config;

import io.k2pool.client.K2Pool;
import io.k2pool.common.util.AESUtil;
import io.k2pool.common.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(K2PoolConfig.class)
public class BeanFactory {

    @Autowired
    private K2PoolConfig config;

    @Bean
    public K2Pool k2Pool() {
        HttpUtil.setConfig(config);
        AESUtil.setConfig(config);
        return new K2Pool();
    }

}