package com.ares.ztserve.service;

import com.ares.ztserve.model.ServiceRecords;

import java.util.List;

/**
 * @author ESy
 * @date 2023/2/15 015 15:43
 */
public interface ServeRecordsService {
    /**
     * 返回所有客服数据
     * */
    List<ServiceRecords> getServiceRecordsAll();
    /**
     * 根据ClientId返回客服数据
     * */
    List<ServiceRecords> getServiceRecordsById(String clientId);
    /**
     * 根据token自动带入客户信息
     * @param firstResponse String
     * @return List
     */
    List<ServiceRecords> getMyRecordsByDate();

}
