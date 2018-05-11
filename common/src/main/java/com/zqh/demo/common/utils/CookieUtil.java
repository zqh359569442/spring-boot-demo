package com.zqh.demo.common.utils;

import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.util.Iterator;
import java.util.Map;

/**
 * 操作cookie
 *
 */
public class CookieUtil {

    private static int cookieAge = 60 * 60 * 2; //默认2小时
    private static String path = "/";           //默认路径/
    private static String domian ="com.zqh.demo";
    /**
     * 往cookie中存放数据
     * @param  response
     * @param  key
     * @param  value
     */
    public  static void set(HttpServletResponse response , @NotNull  String key, String value){
        set(response,key,value,domian,path,cookieAge,false);
    };

    /**
     * 往cookie中存放Map数据，
     * @param response
     * @param map
     */
    public static void set(HttpServletResponse response, Map<String,String> map ){
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()){
            String key = (String) it.next();
            set(response,key,map.get(key),domian,path,cookieAge,false);
        }
    }

    /**
     * 往cookie中存放map数据,可以自定义路径以及有效时间
     * @param response
     * @param map
     */
    public static void set(HttpServletResponse response, Map<String,String> map ,String myPath,int age){
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()){
            String key = (String) it.next();
            set(response,key,map.get(key),myPath,age);
        }
    }


    /**
     * 往cookie中存放数据,可以自定义路径以及有效时间
     * @param  response
     * @param  key
     * @param  value
     * @param  myPath
     * @param  age
     */
    public  static void set(HttpServletResponse response ,@NotNull String key,String value,@NotNull String myPath, int age){
            set(response, key, value, domian, myPath, age, false);
    };

    /**
     * 保存
     * @param response
     * @param domain
     * @param key
     * @param value
     * @param maxAge
     */
    public static void set(HttpServletResponse response,@NotNull  String key, String value, String domain, String path, int maxAge, boolean isHttpOnly) {
        Cookie cookie = new Cookie(key, value);
        if (domain != null) {
            cookie.setDomain(domain);
        }
        cookie.setPath(path);
        cookie.setMaxAge(maxAge);
        cookie.setHttpOnly(isHttpOnly);
        response.addCookie(cookie);
    }

    public static String getValue(HttpServletRequest request, @NotNull String key){
        Cookie cookie = getCookie(request,key);
        if (cookie != null){
            return cookie.getValue();
        }
        return null;
    }




    /**
     *  获取到cookie 对象
     * @param request
     * @param key
     * @return
     */
    public static Cookie getCookie(HttpServletRequest request, @NotNull String key){
        Cookie[] cookies = request.getCookies();
        if(cookies!=null || cookies.length <1) {
            for (Cookie cookie:cookies) {
                if(cookie.getName().equals(key)){
                    return cookie;
                }
            }
        }
        return null;
    }

    public static void main(String []args){
        //Cookie 的name 不能为空
        Cookie cookie = new Cookie(null,null);

    }
}
