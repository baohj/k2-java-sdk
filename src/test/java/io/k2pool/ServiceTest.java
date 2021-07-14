package io.k2pool;

import com.alibaba.fastjson.JSON;
import io.k2pool.client.K2Pool;
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
    private K2Pool k2Pool;
    
    @Test
    public void serviceTest(){
        TokenVO sr = k2Pool.getToken();
        log.info("返回值:{}", JSON.toJSONString(sr));
        
    }
}
