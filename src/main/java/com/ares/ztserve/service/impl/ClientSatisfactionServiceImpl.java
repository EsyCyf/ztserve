package com.ares.ztserve.Service.impl;

import com.ares.ztserve.Mapper.ClientSatisfactionMapper;
import com.ares.ztserve.Model.ClientSatisfaction;
import com.ares.ztserve.Service.ClientSatisfactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ESy
 * @date 2023/2/21 021 10:38
 */
@Service
public class ClientSatisfactionServiceImpl implements ClientSatisfactionService {
    @Autowired
    private ClientSatisfactionMapper clientSatisfactionMapper;

    @Override
    public int getClientSatisfactionId() {
        return clientSatisfactionMapper.getClientSatisfactionId();
    }

    @Override
    public List<ClientSatisfaction> getClientSatisfactionAll() {
        return clientSatisfactionMapper.getClientSatisfactionAll();
    }

    @Override
    public int insertClientSatisfaction(String clientId, String type, int satisDegree, String satisDesc, String feedback) {
        int cstId = clientSatisfactionMapper.getClientSatisfactionId();
        clientSatisfactionMapper.insertClientSatisfaction(cstId, clientId, type, satisDegree, satisDesc, feedback);
        return cstId;
    }
}
