package io.k2pool.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.k2pool.common.Constants;
import io.k2pool.common.ContentTypeEnum;
import io.k2pool.common.config.K2PoolConfig;
import io.k2pool.common.util.HttpUtil;
import io.k2pool.common.util.RSAUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class K2Pool {

    @Autowired
    private K2PoolConfig config;
    /**
     * 获取token
     * @return
     */
    public String getToken(){
        String token = null;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tokenExpires",config.getTokenExpires());
        jsonObject.put("accessKey",config.getAccessKey());
        String resutl = HttpUtil.doPost(Constants.token_url,RSAUtil.encrypt(jsonObject.toJSONString()), null, ContentTypeEnum.TEXT);
        JSONObject resutlJson = JSON.parseObject(resutl);
        if(Constants.SUCCESS.equals(resutlJson.getString("code"))){
            token = resutlJson.getString("data");

        }
        return token;
    }
}
