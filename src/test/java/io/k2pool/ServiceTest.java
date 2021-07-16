package io.k2pool;

import com.alibaba.fastjson.JSON;
import io.k2pool.client.K2Pool;
import io.k2pool.common.Result;
import io.k2pool.entity.ForeignNetworkVO;
import io.k2pool.entity.ForeignPlatformVO;
import io.k2pool.entity.ForeignSysMinerInfoVO;
import io.k2pool.entity.TokenVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
@Slf4j
public class ServiceTest {

    @Autowired
    private K2Pool k2Pool;
    String token="eyJhbGciOiJIUzI1NiJ9.eyJBQ0NFU1NLRVkiOiIzZTQ0MzQ2OTllMTM0N2VkODI0NTgxM2Y4Yzk2ZjY0ZiIsImlhdCI6MTYyNjQxOTc0NywicGxhdGZvcm0iOiJhcGkifQ.qVnMY2cSlHclsJmFx8xTetY1TZwpFcEZh1_i0ebCzU4";

    @Before
    public void init(){
        K2Pool.init(token);
    }

    @Test
    public void tokenTest(){
        Result<TokenVO> token = k2Pool.getToken();
        System.out.println("token信息:{}");
        log.info("token信息:{}", JSON.toJSONString(token));
    }

    @Test
    public void network(){
        Result<ForeignNetworkVO> result = k2Pool.network();
        log.info("network 结果:{}", JSON.toJSONString(result));
    }

    @Test
    public void platform(){
        Result<ForeignPlatformVO> result = k2Pool.platform();
        log.info("platform 结果:{}", JSON.toJSONString(result));
    }


    @Test
    public void miner(){
        Result<ForeignSysMinerInfoVO> result = k2Pool.miner("f054370");
        log.info("miner 结果:{}", JSON.toJSONString(result));
    }

    @Test
    public void user(){
        Result<List<ForeignSysMinerInfoVO>> result = k2Pool.user("97067dddaa11473bafb8dd8bded87ff9");
        log.info("user 结果:{}", JSON.toJSONString(result));
    }
}
