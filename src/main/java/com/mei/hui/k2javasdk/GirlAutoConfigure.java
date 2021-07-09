package com.mei.hui.k2javasdk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shangbin
 * @version v1.0.0
 * @date 2021/7/8 19:17
 **/
@Configuration
@EnableConfigurationProperties(GirlProperties.class)
@ConditionalOnClass(Girl.class)
public class GirlAutoConfigure {

    @Autowired
    private GirlProperties girlProperties;

    @Bean
    @ConditionalOnMissingBean(Girl.class)
    public Girl getGirl(){
        Girl girl = new Girl();
        girl.setAge(girlProperties.getAge());
        girl.setName(girlProperties.getName());
        return girl;
    }

}
