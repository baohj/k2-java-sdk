package com.mei.hui.k2javasdk;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author shangbin
 * @version v1.0.0
 * @date 2021/7/8 19:16
 **/

@ConfigurationProperties(prefix = "com.girl")
public class GirlProperties {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "GirlProperties{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


}
