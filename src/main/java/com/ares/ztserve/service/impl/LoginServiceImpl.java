package com.ares.ztserve.service.impl;

import com.ares.ztserve.mapper.LoginMapper;
import com.ares.ztserve.model.Client;
import com.ares.ztserve.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ESy
 * @date 2023/2/23 023 16:39
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public Client getClientInfo(String key) {
        return loginMapper.getClientByKey(key);
    }
}
