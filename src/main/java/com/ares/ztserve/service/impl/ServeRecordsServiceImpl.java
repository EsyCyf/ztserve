package com.ares.ztserve.service.impl;

import com.ares.ztserve.mapper.ServeRecordsMapper;
import com.ares.ztserve.model.ServiceRecords;
import com.ares.ztserve.service.ServeRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
    *@author ESy
    *@date 2023/2/15 015 15:58
*/
@Service
public class ServeRecordsServiceImpl implements ServeRecordsService {

    @Autowired
    private ServeRecordsMapper serveRecordsMapper;
    @Override
    public List<ServiceRecords> getServiceRecordsAll() {
        return serveRecordsMapper.getServiceRecordsAll();
    }

    @Override
    public List<ServiceRecords> getServiceRecordsById(String clientId) {
        return serveRecordsMapper.getServiceRecordsById(clientId);
    }

    @Override
    public List<ServiceRecords> getServeRecords(String customerNo, String emailAddress, String userRole, String firstResponse) {
        return serveRecordsMapper.getServeRecords(customerNo, emailAddress, userRole, firstResponse);
    }


}
