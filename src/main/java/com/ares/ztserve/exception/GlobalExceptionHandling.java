package com.ares.ztserve.exception;

import com.ares.ztserve.model.Msg;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * @author ESy
 * @date 2023/3/2 002 11:47
 */
@RestControllerAdvice
public class GlobalExceptionHandling {
    @ExceptionHandler(ShiroException.class)
    public Msg doHandleShiroException(
            ShiroException e) {
        Msg msg;
        if (e instanceof UnknownAccountException) {

            msg=Msg.fail("账户不存在");
        } else if (e instanceof LockedAccountException) {
            msg=Msg.denyAccess("账户已被禁用");
        } else if (e instanceof IncorrectCredentialsException) {
            msg=Msg.fail("密码不正确");
        } else if (e instanceof AuthorizationException) {
            msg=Msg.denyAccess("没有此操作权限");
        } else {
            msg=Msg.fail("系统维护中");
        }
        e.printStackTrace();
        return msg;
    }

    //定义全局异常处理
    @ExceptionHandler(value = RuntimeException.class)
    public Msg topException(RuntimeException e) {
        e.printStackTrace();
        return Msg.fail(String.valueOf(e));
    }
}
