package com.mei.hui;

import com.bao.hong.Application;
import com.bao.hong.service.MeiHuiService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
class K2JavaSdkApplicationTests {

    @Autowired
    private MeiHuiService meiHuiService;

    @Test
    void contextLoads() {
        log.info(meiHuiService.getConfig());
    }

}
