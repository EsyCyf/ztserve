package com.ares.ztserve.utils;

import com.ares.ztserve.model.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author ESy
 * @date 2023/2/22 022 16:42
 * Token工具类：
 * 生成Token:createToken(User user)
 * 验证token:checkToken(String token)
 */
public class TokenUtil {
    public static void main(String[] args) {
        User u = new User();
        u.setUsername("1765");
        System.out.println(createToken(u));
    }

    /*过期时间*/
    private static final long EXPIRE_TIME = 10 * 60 * 60 * 1000;

    /*密钥*/
    private static final String PRIVATE_KEY = "abcde";

    /**
     * 签名生成
     *
     * @param user
     * @return String token
     */
    public static String createToken(User user) {
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                //header
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                //payload
                .claim("username",user.getUsername())
                .claim("role",user.getPassword())
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE_TIME))
                .setId(UUID.randomUUID().toString())
                //signature
                .signWith(SignatureAlgorithm.HS256,PRIVATE_KEY)
                .compact();

        return jwtToken;
    }

    /**
     * 验证 token信息 是否正确
     *
     * @param token 被解析 JWT
     * @return boolean 是否正确
     */
    public static boolean checkToken(String token) {
        //获取签名密钥
        //String key = userEntity.getUserPassword();
        //获取DefaultJwtParser
        try {
            Jwts.parser()
                    /*设置 密钥*/
                    .setSigningKey(PRIVATE_KEY)
                    /*设置需要解析的 token*/
                    .parseClaimsJws(token).getBody();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}