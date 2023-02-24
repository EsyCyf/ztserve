package com.ares.ztserve.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.ares.ztserve.model.Client;
import com.ares.ztserve.model.ClientHolder;
import com.ares.ztserve.utils.TokenUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ESy
 * @date 2023/2/23 023 9:27
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        String url = request.getRequestURI();
        System.out.println("esytest01"+"url:"+url);
        response.setCharacterEncoding("utf-8");
        //前端vue将token添加在请求头中
        String token = request.getHeader("token");
        if(token != null){
            Client client = new Client();
            boolean result = TokenUtil.verify(token,client);
            if(result){
                ClientHolder.saveClient(client);
                System.out.println("通过拦截器");
                return true;
            }
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try{
            JSONObject json = new JSONObject();
            json.put("msg","token verify fail");
            json.put("code","50000");
            response.getWriter().append(json.toJSONString());
            System.out.println("认证失败，未通过拦截器!!!");

        }catch (Exception e){
            e.printStackTrace();
            response.sendError(500);
            return false;
        }
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ClientHolder.removeClient();
    }
}
