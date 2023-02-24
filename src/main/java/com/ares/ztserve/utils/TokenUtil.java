package com.ares.ztserve.utils;

import com.ares.ztserve.model.Client;
import com.ares.ztserve.model.ClientHolder;
import com.ares.ztserve.model.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

/**
 * @author ESy
 * @date 2023/2/22 022 16:42
 * Token工具类：
 * 生成Token:createToken(User user)
 * 验证token:checkToken(String token)
 */
public class TokenUtil {
    /**
     * 过期时间，单位毫秒，例如10小时：10*60*60*1000
     */
    private static final long EXPIRE_TIME= 60*60*1000;
    /**
     * 密钥盐
     */
    private static final String TOKEN_SECRET="esy";
    /**
     * 签名生成
     * @param client
     * @return
     */
    public static String sign(Client client){
        String token = null;
        try {
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("customerNo", client.getCustomerNo())
                    .withClaim("emailAddress", client.getEmailAddress())
                    .withClaim("userRole", client.getUserRole())
                    .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                    // 使用了HMAC256加密算法。
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (Exception e){
            e.printStackTrace();
        }
        return token;
    }
    /**
     * 签名验证
     * @param token
     * @return
     */
    public static boolean verify(String token,Client client){
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT jwt = verifier.verify(token);
            System.out.println("认证通过：");
            System.out.println("customerNo: " + jwt.getClaim("customerNo").asString());
            System.out.println("过期时间：      " + jwt.getExpiresAt());
            client.setCustomerNo(jwt.getClaim("customerNo").asString());
            client.setEmailAddress(jwt.getClaim("emailAddress").asString());
            client.setUserRole(jwt.getClaim("userRole").asString());
            return true;
        } catch (Exception e){
            return false;
        }
    }


}