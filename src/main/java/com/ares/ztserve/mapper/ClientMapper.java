package com.ares.ztserve.mapper;

import com.ares.ztserve.model.Client;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ESy
 * @date 2023/2/27 027 9:33
 */
@Mapper
public interface ClientMapper {
    /**
     *
     * @param email
     * @return
     */
    Client findClientByEmail(String email);
}
