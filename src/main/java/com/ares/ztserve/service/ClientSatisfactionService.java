package com.ares.ztserve.service;

import com.ares.ztserve.model.ClientSatisfaction;

import java.util.List;

/**
 * @author ESy
 * @date 2023/2/21 021 10:38
 */
public interface ClientSatisfactionService {
    /**
     * 获取id
     */
    int getClientSatisfactionId();

    /**
     * 查询用户满意度ALL
     */
    List<ClientSatisfaction> getClientSatisfactionAll();

    /**
     * 新增用户满意度
     */
    int insertClientSatisfaction(String email, String type, int satisDegree, String satisDesc, String feedback);
}
