package com.ares.ztserve.service.impl;

import com.ares.ztserve.model.Msg;
import com.ares.ztserve.model.User;
import com.ares.ztserve.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author ESy
 * @date 2023/2/28 028 13:33
 */
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final UserServiceImpl userService;
    private final StringRedisTemplate redisTemplate;

    /**
     * MUTI_LOGIN_ALLOWED 是否允许多端登录
     */
    private static final boolean MULTI_LOGIN_ALLOWED = true;
    /**
     * EXPIRE_TIME 单位秒
     */
    private static final long EXPIRE_TIME = 7200;

    @Override
    public Msg login(String username, String password) {
        User user;
        try {
            user = userService.findUserByName(username);
        } catch (Exception e) {
            return Msg.fail("登录失败");
        }
        System.out.println("username:"+username);
        System.out.println("password:"+password);

        System.out.println("密码是：" + user.getPassword());
        if (user.getPassword().equals(password)) {
            /*System.out.println("登录成功：username： " + username + " password: " + password);*/
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            /*System.out.println("token: " + token);*/
            /*限制多端登录，考虑到有可能增加的请求刷新时长问题，暂不使用*/
            if (!MULTI_LOGIN_ALLOWED) {
                if (Boolean.TRUE.equals(redisTemplate.hasKey(username))) {
                    String oldToken = redisTemplate.opsForValue().get(username);
                    if (oldToken != null) {
                        redisTemplate.delete(oldToken);
                    }
                }
                redisTemplate.opsForValue().set(username, token, EXPIRE_TIME, TimeUnit.SECONDS);
            }

            redisTemplate.opsForValue().set(token, username, EXPIRE_TIME, TimeUnit.SECONDS);
            System.out.println("redis返回username：" + (String) redisTemplate.opsForValue().get(token));
            System.out.println("redis返回token：" + (String) redisTemplate.opsForValue().get(username));
            Msg msg = Msg.success("登录成功");
            msg.add("token", token);
            return msg;
        }
        return Msg.fail("登录失败");
    }
}
