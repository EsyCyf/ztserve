package com.ares.ztserve.controller;

import com.ares.ztserve.model.Msg;
import com.ares.ztserve.model.User;
import com.ares.ztserve.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
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

    @ApiOperation(value = "登录接口，返回状态码+token，账号密码对应xx_personnel_base.email和user_password")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Msg loginByname(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = userService.findUserByName(username);
        System.out.println("密码是："+user.getPassword());
        if (user.getPassword().equals(password)) {
            System.out.println("登录成功：username： " + username + " password: " + password);
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            System.out.println("token: " + token);
            redisTemplate.opsForValue().set(token,username,3600, TimeUnit.SECONDS);
            System.out.println("redis返回："+(String) redisTemplate.opsForValue().get(token));
            Msg msg = Msg.success("登录成功");
            msg.add("token",token);
            return msg;
        }
        return Msg.fail("登录失败");
    }

    /*@RequiresPermissions("99")
    @GetMapping("/login1")
    public Msg index(@RequestHeader String token){
        System.out.println("token: " + token);
        return Msg.success("yes");
    }*/
}
