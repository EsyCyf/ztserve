package com.ares.ztserve.controller;

import com.ares.ztserve.model.Client;
import com.ares.ztserve.model.Msg;
import com.ares.ztserve.model.ServiceRecords;
import com.ares.ztserve.model.User;
import com.ares.ztserve.service.impl.ClientSatisfactionServiceImpl;
import com.ares.ztserve.service.impl.ClientServiceImpl;
import com.ares.ztserve.service.impl.ServeRecordsServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ESy
 * @date 2023/2/27 027 11:06
 */
@RestController
@RequestMapping(value = "/app")
@CrossOrigin
@RequiredArgsConstructor
public class AppController {
    private final ServeRecordsServiceImpl serveRecordsService;
    private final ClientSatisfactionServiceImpl clientSatisfactionService;
    private final ClientServiceImpl clientService;

    @ApiOperation(value = "新增用户满意数据(用户id自动带出)，后台表：xx_cst")
    @RequestMapping(value = "/insertClientSatis", method = RequestMethod.POST)
    public Msg insertClientSatisfaction(
//            @ApiParam("客户id") @RequestParam("clientId") String clientId,
            @ApiParam("满意度") @RequestParam("stDegree") int stDegree,
            @ApiParam("满意度描述") @RequestParam(value = "stDesc") String stDesc,
            @ApiParam("问题分类") @RequestParam("type") String type,
            @ApiParam("反馈") @RequestParam(value = "feedback", required = false) String feedback
    ) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        int id = clientSatisfactionService.insertClientSatisfaction(user.getAccount(), type, stDegree, stDesc, feedback);
        Msg msg = Msg.success("新增成功");
        msg.add("id", id);
        //Client client = clientService.findClientByEmail(username);
        return msg;
    }

    @ApiOperation(value = "返回当前用户权限下的维护记录")
    @RequestMapping(value = "/getMyRecords", method = RequestMethod.GET)
    public List<ServiceRecords> getMyServiceRecords(
            @ApiParam("年月，如2023/02，不传入则为全部") @RequestParam(value = "firstResponse", required = false) String firstResponse
    ) {

        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Client client = clientService.findActiveClientByName(user.getAccount());
        System.out.println("client is : " + client);
        return serveRecordsService.getServeRecords(
                client.getCustomNo(),
                client.getUserName(),
                client.getUserRole(),
                firstResponse);
    }



}
