package com.bao.hong.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "k2pool")
public class K2PoolProperties {

    private String name;
}
