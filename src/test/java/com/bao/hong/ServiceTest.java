package com.bao.hong;

import com.bao.hong.service.K2Pool;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
@Slf4j
public class ServiceTest {

    @Autowired
    private K2Pool meiHuiService;
    
    @Test
    public void serviceTest(){
        /*String content = "美辉科技有限公司";
        System.out.println("原文=" + content);
        String s1 = AESUtil.encrypt(content);
        System.out.println("加密结果=" + s1);
        System.out.println("解密结果="+AESUtil.decrypt(s1));*/
        
    }
}
