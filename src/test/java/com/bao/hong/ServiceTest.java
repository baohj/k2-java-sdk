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
        String str = meiHuiService.getConfig();
        log.info(str);
        
    }
}
