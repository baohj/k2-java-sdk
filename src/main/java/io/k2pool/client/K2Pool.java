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
     */
    public Result<ForeignNetworkVO> network(String token){
        String resutl = HttpUtil.doPost(Constants.network_url,null, token);
        Result<ForeignNetworkVO> vo = JSON.parseObject(resutl, new TypeReference<Result<ForeignNetworkVO>>(){});
        return vo;
    }
    /**
     * 获取平台数据
     */
    public Result<ForeignPlatformVO> platform(String token){
        String resutl = HttpUtil.doPost(Constants.platform_url,null, token);
        Result<ForeignPlatformVO> vo = JSON.parseObject(resutl, new TypeReference<Result<ForeignPlatformVO>>(){});
        return vo;
    }
    /**
     * 获取平台旷工数据
     */
    public Result<ForeignSysMinerInfoVO> miner(String token){
        String resutl = HttpUtil.doPost(Constants.miner_url,null, token);
        Result<ForeignSysMinerInfoVO> vo = JSON.parseObject(resutl, new TypeReference<Result<ForeignSysMinerInfoVO>>(){});
        return vo;
    }
    /**
     * 获取平台旷工数据
     */
    public Result<List<ForeignSysMinerInfoVO>> user(String token){
        String resutl = HttpUtil.doPost(Constants.user_url,null, token);
        Result<List<ForeignSysMinerInfoVO>> vo = JSON.parseObject(resutl, new TypeReference<Result<List<ForeignSysMinerInfoVO>>>(){});
        return vo;
    }

}
