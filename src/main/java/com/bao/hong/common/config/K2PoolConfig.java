package com.bao.hong.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "k2pool")
public class K2PoolConfig {

    /**
     * 用户唯一标识
     */
    private String accessKey;

    /**
     * 秘钥
     */
    private String secretKey;

    /**
     * token过期时间，单位分钟
     */
    private Long tokenExpires;
}
