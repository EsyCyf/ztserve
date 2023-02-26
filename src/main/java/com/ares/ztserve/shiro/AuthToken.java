package com.ares.ztserve.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author ESy
 * @date 2023/2/26 026 23:12
 */
public class AuthToken extends UsernamePasswordToken {

    String token;

    public AuthToken(String token){
        this.token=token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
