package com.ares.ztserve.mapper;


import com.ares.ztserve.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ESy
 * @date 2023/2/26 026 22:18
 */
@Mapper
public interface UserMapper {
    User findUserByName(String username);
}
