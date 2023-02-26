package com.ares.ztserve.controller;

import com.ares.ztserve.model.User;
import com.ares.ztserve.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author ESy
 * @date 2023/2/26 026 22:28
 */
@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginByname(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = userService.findUserByName(username);
        System.out.println("密码是："+user.getPassword());
        if (user.getPassword().equals(password)) {
            System.out.println("登录成功：username： " + username + " password: " + password);
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            System.out.println("token: " + token);
            redisTemplate.opsForValue().set(token,username,3600, TimeUnit.SECONDS);
            System.out.println("redis返回："+(String) redisTemplate.opsForValue().get(token));
            return token;
        }
        return "登录失败";
    }
}
