package com.ares.ztserve.service.impl;

import com.ares.ztserve.mapper.UserMapper;
import com.ares.ztserve.model.User;
import com.ares.ztserve.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ESy
 * @date 2023/2/26 026 22:27
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Override
    public User findUserByName(String username) {
        return userMapper.findUserByName(username);
    }
}
