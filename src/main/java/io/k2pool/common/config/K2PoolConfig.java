package io.k2pool.common.config;

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
     * 公钥
     */
    private String publicKey;
    /**
     * token过期时间，单位分钟
     */
    private Long tokenExpires;
    /**
     * k2Pool平台域名
     */
    private String domain;

}
