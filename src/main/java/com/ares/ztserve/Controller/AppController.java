package com.ares.ztserve.Controller;

import com.ares.ztserve.Model.ServiceRecords;
import com.ares.ztserve.Service.impl.ServeRecordsServiceImpl;
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

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "hello";
    }

    @RequestMapping(value = "/getRecordsAll",method = RequestMethod.GET)
    public List<ServiceRecords> getServiceRecordsAll(){
        return serveRecordsService.getServiceRecordsAll();
    }

    @RequestMapping(value = "/getRecordsById",method = RequestMethod.GET)
    public List<ServiceRecords> getServiceRecordsById(@RequestParam String clientId){
        return serveRecordsService.getServiceRecordsById(clientId);
    }


}
