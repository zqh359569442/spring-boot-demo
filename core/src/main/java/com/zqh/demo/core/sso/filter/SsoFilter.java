package com.zqh.demo.core.sso.filter;




import com.zqh.demo.common.utils.CookieUtil;
import com.zqh.demo.common.utils.TokenUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SsoFilter extends HttpServlet implements HandlerInterceptor {

    /**
     * 在访问系统之前拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * 思路：
         * 1.未登陆  直接访问， 拦截重定向至登陆页面，重新登陆
         *
         * 2.已登陆，
         *      2.1  token 未过期，不拦截
         *      2.2  token 已过期，删除旧token，同时跳转至登陆页面，重新登陆
         *
         * 3.换机登陆
         *      3.1 主要校验mac地址
         *
         * 中间件：redis分布式存储token
         *
         * 工具：
         */

        //获取到访问的Token
         String value = CookieUtil.getValue(request,"com.zqh.demo");
         String userName = CookieUtil.getValue(request,"com.zqh.user");
         String token = TokenUtil.createToken(userName);





         return  true;
    }


    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
