package com.ares.ztserve.service.impl;

import com.ares.ztserve.mapper.ClientSatisfactionMapper;
import com.ares.ztserve.model.ClientSatisfaction;
import com.ares.ztserve.service.ClientSatisfactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ESy
 * @date 2023/2/21 021 10:38
 */
@Service
@RequiredArgsConstructor
public class ClientSatisfactionServiceImpl implements ClientSatisfactionService {
    private final ClientSatisfactionMapper clientSatisfactionMapper;
    public final int getClientSatisfactionId() {
        return clientSatisfactionMapper.getClientSatisfactionId();
    }

    @Override
    public List<ClientSatisfaction> getClientSatisfactionAll() {
        return clientSatisfactionMapper.getClientSatisfactionAll();
    }

    @Override
    public int insertClientSatisfaction(String userName, String type, int satisDegree, String satisDesc, String feedback) {
        int cstId = clientSatisfactionMapper.getClientSatisfactionId();
        clientSatisfactionMapper.insertClientSatisfaction(cstId, userName, type, satisDegree, satisDesc, feedback);
        return cstId;
    }
}
