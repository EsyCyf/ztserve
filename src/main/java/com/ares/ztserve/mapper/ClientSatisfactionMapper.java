package com.ares.ztserve.mapper;

import com.ares.ztserve.model.ClientSatisfaction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ESy
 * @date 2023/2/21 021 10:05
 */
@Mapper
public interface ClientSatisfactionMapper {
    /**
     * 获取id
     * */
    int getClientSatisfactionId();
    /**
     * 查询用户满意度ALL
     * */
    List<ClientSatisfaction> getClientSatisfactionAll();
    /**
     * 新增用户满意度
     * */
    int insertClientSatisfaction(int cstId,String email, String type,int satisDegree,String satisDesc,String feedback);
}
