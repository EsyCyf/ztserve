package com.ares.ztserve.controller;

import com.ares.ztserve.model.Client;
import com.ares.ztserve.model.User;
import com.ares.ztserve.service.LoginService;
import com.ares.ztserve.service.impl.LoginServiceImpl;
import com.ares.ztserve.utils.TokenUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ESy
 * @date 2023/2/22 022 17:13
 * 登录管理
 */
@RestController
@CrossOrigin
@RequestMapping
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;

    @ApiOperation(value = "登录接口，返回token")
    @RequestMapping(value = "/login/{key}", method = RequestMethod.GET)
    public Map<String, String> loginByKey(@PathVariable String key) {
        Map<String, String> map = new HashMap<String, String>();
        Client client = loginService.getClientInfo(key);
        if (null != client.getCustomerNo() &&
                null != client.getUserRole() &&
                null != client.getEmailAddress()) {
            map.put("token", TokenUtil.sign(client));
            map.put("msg", "success");
            return map;
        }
        map.put("msg", "fail");
        return map;
    }

}
