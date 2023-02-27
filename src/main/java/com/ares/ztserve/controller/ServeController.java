package com.ares.ztserve.controller;

import com.ares.ztserve.model.Client;
import com.ares.ztserve.model.ClientSatisfaction;
import com.ares.ztserve.model.ServiceRecords;
import com.ares.ztserve.service.impl.ClientSatisfactionServiceImpl;
import com.ares.ztserve.service.impl.ClientServiceImpl;
import com.ares.ztserve.service.impl.ServeRecordsServiceImpl;
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
public class ServeController {
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



}
