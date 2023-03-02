package com.ares.ztserve.service.impl;

import com.ares.ztserve.mapper.ClientMapper;
import com.ares.ztserve.model.Client;
import com.ares.ztserve.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ESy
 * @date 2023/2/27 027 9:38
 */
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientMapper clientMapper;
    @Override
    public Client findActiveClientByName(String userName) {
        return clientMapper.findActiveClientByName(userName);
    }

    @Override
    public List<Client> getClientInfo(Client client) {
        return clientMapper.getClientInfo(client);
    }
}
