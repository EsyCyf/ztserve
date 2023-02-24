package com.ares.ztserve.service;

import com.ares.ztserve.model.Client;
import com.ares.ztserve.model.User;

/**
 * @author ESy
 * @date 2023/2/23 023 16:07
 */
public interface LoginService {

    /***
     * 根据密文获取客户信息
     * @param key String
     * @return Client
     */
    public Client getClientInfo(String key);

}
