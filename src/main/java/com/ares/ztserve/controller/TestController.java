package com.ares.ztserve.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ESy
 * @date 2023/2/22 022 11:30
 */
@RestController
@RequestMapping(value = "/test")
@CrossOrigin
public class TestController {


    @ApiOperation(value = "设置session属性 返回sessionid和属性")
    @RequestMapping(value = "setSession", method = RequestMethod.GET)
    public Map<String, String> setClientId(@RequestParam String sessionName, @RequestParam String sessionValue, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute(sessionName, sessionValue);
        HashMap<String, String> map = new HashMap<>();
        setSeesionMap(map,session);
        return map;
    }

    @ApiOperation(value = "获取当前sessionId和属性")
    @RequestMapping(value = "getSession", method = RequestMethod.GET)
    public Map<String, String> getSessionContentById(HttpServletRequest request) {
        HashMap<String, String> map = new HashMap<>();
        HttpSession session = request.getSession();
        setSeesionMap(map,session);
        return map;
    }

    /***
     *
     * @param map
     * @param session
     * 将sessionid和session属性加入map中
     */
    private void setSeesionMap(HashMap<String,String> map,HttpSession session){
        map.put("sessionId", session.getId());
        // 获取session中所有的键值
        Enumeration<?> enumeration = session.getAttributeNames();
        // 遍历enumeration
        while (enumeration.hasMoreElements()) {
            // 获取session的属性名称
            String name = enumeration.nextElement().toString();
            // 根据键值取session中的值
            Object value = session.getAttribute(name);
            map.put(name, (String) value);
            // 打印结果
            //System.out.println("name:" + name + ",value:" + value);
        }
        /*遍历输出map内容*/
        map.forEach((name, value) -> {
            System.out.println("name:" + name + ",value:" + value);
        });
    }



}
