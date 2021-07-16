package io.k2pool.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import io.k2pool.common.Constants;
import io.k2pool.common.Result;
import io.k2pool.common.config.K2PoolConfig;
import io.k2pool.common.util.AESUtil;
import io.k2pool.common.util.HttpUtil;
import io.k2pool.common.util.RSAUtil;
import io.k2pool.entity.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class K2Pool {

    @Autowired
    private K2PoolConfig config;
    /**
     * 获取token
     * @return
     */
    public Result<TokenVO> getToken(){
        TokenBO tokenBO = new TokenBO().setAccessKey(config.getAccessKey()).setTokenExpires(config.getTokenExpires());
        String bodyEncry = AESUtil.encrypt(JSON.toJSONString(tokenBO));
        String aesKeyEncry = RSAUtil.encrypt(config.getAesKey());

        JSONObject json = new JSONObject();
        json.put("bodyEncry",bodyEncry);
        json.put("aesKeyEncry",aesKeyEncry);

        String resutl = HttpUtil.doPost(Constants.token_url,json.toJSONString(), null);
        Result<TokenVO> vo = JSON.parseObject(resutl, new TypeReference<Result<TokenVO>>(){});
        return vo;
    }
    /**
     * 获取全网数据
     * @return
     */
    public Result<ForeignNetworkVO> network(){
        String resutl = HttpUtil.doPost(Constants.network_url,null, null);
        Result<ForeignNetworkVO> vo = JSON.parseObject(resutl, new TypeReference<Result<ForeignNetworkVO>>(){});
        return vo;
    }
    /**
     * 获取平台数据
     * @return
     */
    public Result<ForeignPlatformVO> platform(){
        String resutl = HttpUtil.doPost(Constants.platform_url,null, null);
        Result<ForeignPlatformVO> vo = JSON.parseObject(resutl, new TypeReference<Result<ForeignPlatformVO>>(){});
        return vo;
    }
    /**
     * 获取平台旷工数据
     * @return
     */
    public Result<ForeignSysMinerInfoVO> miner(){
        String resutl = HttpUtil.doPost(Constants.miner_url,null, null);
        Result<ForeignSysMinerInfoVO> vo = JSON.parseObject(resutl, new TypeReference<Result<ForeignSysMinerInfoVO>>(){});
        return vo;
    }
    /**
     * 获取平台旷工数据
     * @return
     */
    public Result<List<ForeignSysMinerInfoVO>> user(){
        String resutl = HttpUtil.doPost(Constants.user_url,null, null);
        Result<List<ForeignSysMinerInfoVO>> vo = JSON.parseObject(resutl, new TypeReference<Result<List<ForeignSysMinerInfoVO>>>(){});
        return vo;
    }

}
