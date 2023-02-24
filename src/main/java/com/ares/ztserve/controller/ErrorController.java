package com.ares.ztserve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ESy
 * @date 2023/2/23 023 11:29
 */
@RestController
public class ErrorController {
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String errMessage(){
        return "DOWN!";
    }
}
