package com.ares.ztserve.service;


import com.ares.ztserve.model.Msg;

/**
 * @author ESy
 * @date 2023/2/28 028 13:30
 */
public interface LoginService {
    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return Msg
     */
    Msg login(String username, String password);
}
