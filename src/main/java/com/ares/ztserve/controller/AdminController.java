package com.ares.ztserve.controller;

import com.ares.ztserve.model.Client;
import com.ares.ztserve.service.impl.ClientServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ESy
 * @date 2023/3/2 002 10:57
 *
 */
@RestController
@RequestMapping(value = "/admin")
@CrossOrigin
@RequiredArgsConstructor
public class AdminController {
    private final ClientServiceImpl clientService;

    /**
     * @RequiresPermissions("99") 仅管理可用
     * @param client
     * @return
     */
    @ApiOperation(value = "返回用户信息，仅管理员可用")
    @RequiresPermissions("99")
    @RequestMapping(value = "/getClientInfo", method = RequestMethod.POST)
    public List<Client> getClientInfo(@RequestBody Client client){
        return clientService.getClientInfo(client);
    }
}
