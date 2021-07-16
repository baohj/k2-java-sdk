package io.k2pool.common;

public interface Constants {

    /**
     * 令牌
     */
    String TOKEN = "token";

    String RSA = "RSA";

    String KEY_ALGORITHM = "AES";

    String SUCCESS = "000000";

    String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    //获取token数据
    String token_url = "/user-server/k2Pool/getToken";

    //获取全网数据
    String network_url = "/miner-server/k2Pool/network";

    //获取K2Pool平台数据
    String platform_url = "/miner-server/k2Pool/platform";

    //获取K2Pool平台旷工数据
    String miner_url = "/miner-server/k2Pool/miner";

    //获取K2Pool平台用户旷工数据
    String user_url = "/miner-server/k2Pool/user";



}
