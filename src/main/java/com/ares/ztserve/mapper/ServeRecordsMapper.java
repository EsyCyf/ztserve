package com.ares.ztserve.mapper;

import com.ares.ztserve.model.ServiceRecords;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ESy
 * @date 2023/2/15 015 16:00
 */
@Mapper
public interface ServeRecordsMapper {
    /**
     * 返回所有客服数据
     * */
    List<ServiceRecords> getServiceRecordsAll();
    /**
     * 根据ClientId返回客服数据
     * */
    List<ServiceRecords> getServiceRecordsById(String clientId);

    /**
     * 获取记录
     * @param customerNo
     * @param userName
     * @param userRole
     * @param firstResponse
     * @return
     */
    List<ServiceRecords> getServeRecords(String customerNo,String userName,String userRole,String firstResponse);



}
