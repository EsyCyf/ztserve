package com.ares.ztserve.mapper;

import com.ares.ztserve.model.Client;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ESy
 * @date 2023/2/23 023 16:29
 */
@Mapper
public interface LoginMapper {
    /***
     * 根据密文获取客户信息
     * @param key String
     * @return Client
     */
    public Client getClientByKey(String key);
}
