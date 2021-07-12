package com.bao.hong.service;


import com.bao.hong.common.config.K2PoolProperties;
import org.springframework.beans.factory.annotation.Autowired;

public class K2Pool {

    @Autowired
    private K2PoolProperties k2PoolProperties;

    public String getConfig(){

        return "恭喜,成功了"+k2PoolProperties.getName();
    }
}
