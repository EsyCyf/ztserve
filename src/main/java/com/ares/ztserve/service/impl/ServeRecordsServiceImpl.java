package com.ares.ztserve.Service.impl;

import com.ares.ztserve.Mapper.ServeRecordsMapper;
import com.ares.ztserve.Model.ServiceRecords;
import com.ares.ztserve.Service.ServeRecordsService;
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
}
