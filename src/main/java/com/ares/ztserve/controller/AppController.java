package com.ares.ztserve.controller;

import com.ares.ztserve.model.ClientSatisfaction;
import com.ares.ztserve.model.ServiceRecords;
import com.ares.ztserve.service.impl.ClientSatisfactionServiceImpl;
import com.ares.ztserve.service.impl.ServeRecordsServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
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

    @ApiOperation(value = "测试用")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "hello";
    }

    @RequestMapping(value = "/getRecordsAll", method = RequestMethod.GET)
    public List<ServiceRecords> getServiceRecordsAll() {
        return serveRecordsService.getServiceRecordsAll();
    }

    @RequestMapping(value = "/getRecordsById", method = RequestMethod.GET)
    public List<ServiceRecords> getServiceRecordsById(@RequestParam String clientId) {
        return serveRecordsService.getServiceRecordsById(clientId);
    }

    @ApiOperation(value = "获取用户满意数据All")
    @RequestMapping(value = "/getClientSatisAll", method = RequestMethod.GET)
    public List<ClientSatisfaction> getClientSatisfactionAll() {
        return clientSatisfactionService.getClientSatisfactionAll();
    }

    @ApiOperation(value = "新增用户满意数据，后台表：xx_cst")
    @RequestMapping(value = "/insertClientSatis", method = RequestMethod.POST)
    public int insertClientSatisfaction(
            @ApiParam("客户id") @RequestParam("clientId") String clientId,
            @ApiParam("满意度") @RequestParam("stDegree") int stDegree,
            @ApiParam("满意度描述") @RequestParam(value = "stDesc",required = false) String stDesc,
            @ApiParam("问题分类") @RequestParam("type") String type,
            @ApiParam("反馈") @RequestParam(value = "feedback",required = false) String feedback
    ) {
        return clientSatisfactionService.insertClientSatisfaction(clientId, type, stDegree, stDesc, feedback);
    }

    @RequestMapping(value = "/getMy", method = RequestMethod.GET)
    public List<ServiceRecords> getMy() {
        return serveRecordsService.getMyRecordsByDate();
    }


}
