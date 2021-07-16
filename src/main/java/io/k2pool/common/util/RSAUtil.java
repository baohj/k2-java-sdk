package io.k2pool.common.util;

import io.k2pool.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;

@Slf4j

public class RSAUtil {

    private static String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKDCPJ0vE1nKepDx4oJRDupkouSQKTbV51SFUgQLDzFyLH9YnIfTdiy9oiZ8XaohfHklFLUY+2brHyf9IkijX2ECAwEAAQ==";
    /**
     * RSA公钥加密
     * @param str
     *            加密字符串
     * @return 密文
     * @throws Exception
     *             加密过程中的异常信息
     */
    public static String encrypt(String str){
        try {
            //base64编码的公钥
            byte[] decoded = Base64.decodeBase64(publicKey);
            RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance(Constants.RSA).generatePublic(new X509EncodedKeySpec(decoded));
            //RSA加密
            Cipher cipher = Cipher.getInstance(Constants.RSA);
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
            return outStr;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("加密异常:",e);
            throw new RuntimeException(e);
        }
    }

}