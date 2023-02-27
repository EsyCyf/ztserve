package com.ares.ztserve.controller;

import com.ares.ztserve.model.Client;
import com.ares.ztserve.model.ClientSatisfaction;
import com.ares.ztserve.model.ServiceRecords;
import com.ares.ztserve.service.impl.ClientSatisfactionServiceImpl;
import com.ares.ztserve.service.impl.ClientServiceImpl;
import com.ares.ztserve.service.impl.ServeRecordsServiceImpl;
import com.ares.ztserve.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ESy
 * @date 2023/2/15 015 16:03
 */
@RestController
@RequestMapping(value = "/serve")
@CrossOrigin
public class AppController {
    @Autowired
    private ServeRecordsServiceImpl serveRecordsService;
    @Autowired
    private ClientSatisfactionServiceImpl clientSatisfactionService;
    @Autowired
    private ClientServiceImpl clientService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @ApiOperation(value = "测试用")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "hello";
    }

    @RequestMapping(value = "/getRecordsAll", method = RequestMethod.GET)
    public List<ServiceRecords> getServiceRecordsAll() {
        return serveRecordsService.getServiceRecordsAll();
    }

    @ApiOperation(value = "根据client_id获取维护记录")
    @RequestMapping(value = "/getRecordsById", method = RequestMethod.GET)
    public List<ServiceRecords> getServiceRecordsById(@RequestParam String clientId) {
        return serveRecordsService.getServiceRecordsById(clientId);
    }

    @ApiOperation(value = "获取用户满意数据All")
    @RequestMapping(value = "/getClientSatisAll", method = RequestMethod.GET)
    public List<ClientSatisfaction> getClientSatisfactionAll() {
        return clientSatisfactionService.getClientSatisfactionAll();
    }

    @ApiOperation(value = "新增用户满意数据(用户id自动带出)，后台表：xx_cst")
    @RequestMapping(value = "/insertClientSatis", method = RequestMethod.POST)
    public int insertClientSatisfaction(
//            @ApiParam("客户id") @RequestParam("clientId") String clientId,
            @ApiParam("满意度") @RequestParam("stDegree") int stDegree,
            @ApiParam("满意度描述") @RequestParam(value = "stDesc") String stDesc,
            @ApiParam("问题分类") @RequestParam("type") String type,
            @ApiParam("反馈") @RequestParam(value = "feedback", required = false) String feedback,
            @RequestHeader String token
    ) {
        String username = stringRedisTemplate.opsForValue().get(token);
        //Client client = clientService.findClientByEmail(username);
        return clientSatisfactionService.insertClientSatisfaction(username, type, stDegree, stDesc, feedback);
    }

    @ApiOperation(value = "返回当前用户权限下的维护记录")
    @RequestMapping(value = "/getMyRecords", method = RequestMethod.GET)
    public List<ServiceRecords> getMyServiceRecords(
            @ApiParam("日月，如2023/02，不传入则为全部") @RequestParam(value = "firstResponse", required = false) String firstResponse,
            @RequestHeader String token) {
        String username = stringRedisTemplate.opsForValue().get(token);
        Client client = clientService.findClientByEmail(username);
        System.out.println("client is : " + client);
        return serveRecordsService.getServeRecords(
                client.getCustomNo(),
                client.getEmail(),
                client.getRole(),
                firstResponse);
    }


}
