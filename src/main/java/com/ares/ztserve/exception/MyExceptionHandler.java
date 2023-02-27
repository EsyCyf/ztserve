package com.ares.ztserve.exception;

import com.ares.ztserve.model.Msg;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ESy
 * @date 2023/2/26 026 23:17
 */
@Controller
public class MyExceptionHandler {

    //捕获AuthorizationException的异常
    @ExceptionHandler(value = AuthorizationException.class)
    @ResponseBody
    public Msg handleException(AuthorizationException e) {
        Msg msg=Msg.denyAccess("权限不足");
        return msg;
    }
}
