package com.ares.ztserve.service;

import com.ares.ztserve.model.User;

/**
 * @author ESy
 * @date 2023/2/26 026 22:19
 */
public interface UserService {
    User findUserByName(String username);

}
