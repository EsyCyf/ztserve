package com.ares.ztserve.service.impl;

import com.ares.ztserve.mapper.ClientMapper;
import com.ares.ztserve.model.Client;
import com.ares.ztserve.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ESy
 * @date 2023/2/27 027 9:38
 */
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientMapper clientMapper;
    @Override
    public Client findClientByEmail(String email) {
        return clientMapper.findClientByEmail(email);
    }
}
