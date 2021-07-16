package io.k2pool.common.util;

import io.k2pool.common.Constants;
import io.k2pool.common.config.K2PoolConfig;
import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;

@Slf4j
public class AESUtil {

    private static K2PoolConfig config;

    public static void setConfig(K2PoolConfig config) {
        AESUtil.config = config;
    }
    /**
     * AES 加密操作
     *
     * @param content 待加密内容
     * @return 返回Base64转码后的加密数据
     */
    public static String encrypt(String content) {
        try {
            // 创建密码器
            Cipher cipher = Cipher.getInstance(Constants.DEFAULT_CIPHER_ALGORITHM);
            byte[] byteContent = content.getBytes("utf-8");
            // 初始化为加密模式的密码器
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(config.getAesKey()));
            // 加密
            byte[] result = cipher.doFinal(byteContent);
            //通过Base64转码返回
            return byte2Base64(result);
        } catch (Exception ex) {
            log.error("加密失败", ex);
            throw new RuntimeException(ex);
        }
    }

    /**
     * AES 解密操作
     * @param content 解决文本
     */
    public static String decrypt(String content) {
        try {
            //实例化
            Cipher cipher = Cipher.getInstance(Constants.DEFAULT_CIPHER_ALGORITHM);
            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(config.getAesKey()));
            //执行操作
            byte[] result = cipher.doFinal(base642Byte(content));
            return new String(result, "utf-8");
        } catch (Exception ex) {
            log.error("解密失败", ex);
            throw new RuntimeException(ex);
        }
    }

    /**
     * 生成加密秘钥
     */
    private static Key getSecretKey(final String key) {
        try {
            KeyGenerator kg = KeyGenerator.getInstance(Constants.KEY_ALGORITHM);
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(key.getBytes());
            kg.init(128, random);
            SecretKey secretKey = kg.generateKey();
            // 转换为AES专用密钥
            return new SecretKeySpec(secretKey.getEncoded(),Constants.KEY_ALGORITHM);
        } catch (Exception ex) {
            log.info("生成加密秘钥异常！");
        }
        return null;
    }

    /**
     * 字节数组转Base64编码
     * @param bytes
     */
    private static String byte2Base64(byte[] bytes) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(bytes);
    }

    /**
     * Base64编码转字节数组
     * @param base64Key
     * @throws Exception
     */
    private static byte[] base642Byte(String base64Key) throws Exception {
        BASE64Decoder decoder = new BASE64Decoder();
        return decoder.decodeBuffer(base64Key);
    }


}
