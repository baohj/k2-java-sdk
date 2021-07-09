package com.mei.hui.k2javasdk;

import org.springframework.stereotype.Repository;

/**
 * @author shangbin
 * @version v1.0.0
 * @date 2021/7/8 15:12
 **/
@Repository
public class PoolTemplate {

    public String testString(){
        System.out.println("testString");
        return "testString";
    }

}
