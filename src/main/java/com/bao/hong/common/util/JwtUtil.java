//package com.bao.hong.common.util;
//
//import com.auth0.jwt.exceptions.JWTCreationException;
//import com.auth0.jwt.exceptions.JWTDecodeException;
//import com.mei.hui.config.jwtConfig.RuoYiConfig;
//import com.mei.hui.util.ErrorCode;
//import com.mei.hui.util.MyException;
//import com.mei.hui.util.SystemConstants;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//@Slf4j
//@Component
//public class JwtUtil {
//
//
//    public static String createToken(Long userId,Long currencyId,String  platform) throws JWTCreationException {
//
//        Map<String, Object> claims = new HashMap<>();
//        claims.put(SystemConstants.USERID,userId);
//        claims.put(SystemConstants.CURRENCYID,currencyId);
//        claims.put(SystemConstants.PLATFORM,platform);
//        String token = Jwts.builder().setClaims(claims).setIssuedAt(new Date())
//                .signWith(SignatureAlgorithm.HS256, staticRuoYiConfig.getJwtSecret()).compact();
//        return token;
//    }
//
//    /**
//     * 验签 并 解决 token
//     * @param encodedToken
//     * @return
//     * @throws JWTDecodeException
//     */
//    public static Claims parseToken(String encodedToken)  {
//        Claims claims = null;
//        try{
//            claims = Jwts.parser()
//                    .setSigningKey(staticRuoYiConfig.getJwtSecret())
//                    .parseClaimsJws(encodedToken)
//                    .getBody();
//        }catch (ExpiredJwtException exp){
//            throw MyException.fail(ErrorCode.MYB_111002.getCode(),ErrorCode.MYB_111002.getMsg());
//        }catch (Exception dex){
//            throw MyException.fail(ErrorCode.MYB_111004.getCode(),"token 验签错误");
//        }
//        return claims;
//    }
//
//
//
//}
