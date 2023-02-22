package com.ares.ztserve.controller;

import com.ares.ztserve.model.User;
import com.ares.ztserve.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ESy
 * @date 2023/2/22 022 17:13
 * 登录管理
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/login")
public class LoginController {
    private final String USERNAME = "APLUS";
    private final String PASSWORD = "1";

    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public User login(@RequestBody User user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        if (USERNAME.equals(user.getUsername()) && PASSWORD.equals(user.getPassword())) {
            user.setToken(TokenUtil.createToken(user));
            System.out.println("login success");
        }
        return user;
    }

}
