package com.star.hermes.util;

import com.alibaba.fastjson2.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created With IDEA Author: Mars Date: 2016/1/18 Time: 13:52 Description:
 */
public class CookieUtil {
    private static final Logger logger = LoggerFactory.getLogger(CookieUtil.class);

    public static int EXPIRE_TIME_DEFAULT = 1 * 60 * 60 * 24 * 30;//默认过期时间为一个月

    /**
     * 写cookie
     *
     * @param response
     * @param key
     * @param value
     * @return
     */
    public static void writeCookie(HttpServletResponse response, String key, String value) {
        writeCookie(response, key, value, "/", EXPIRE_TIME_DEFAULT);
    }

    /**
     * 写cookie,加失效时间
     *
     * @param response
     * @param key
     * @param value
     * @param second
     * @return
     */
    public static void writeCookie(HttpServletResponse response, String key, String value, int second) {
        writeCookie(response, key, value, "/", second);
    }

    /**
     * 写cookie
     *
     * @param key
     * @param value
     * @param path
     * @param second
     */
    public static void writeCookie(HttpServletResponse response, String key, String value, String path, int second) {
        if (StringUtils.isEmpty(value)) {
            return;
        }
        Cookie nameCookie = new Cookie(key, Escape.escape(value));
        nameCookie.setMaxAge(second);
        nameCookie.setPath(path);
        logger.info("writeCookie = {}", JSONObject.toJSONString(nameCookie));
        response.addCookie(nameCookie);
    }

    /**
     * 删除cookie
     *
     * @param response
     * @param key
     * @param request
     * @return
     */
    public static void removeCookie(HttpServletRequest request, HttpServletResponse response, String key) {
        removeCookie(request, response, key, "/");
    }

    /**
     * 移除cookie
     *
     * @param request
     * @param response
     * @param key
     * @param path
     */
    public static void removeCookie(HttpServletRequest request, HttpServletResponse response, String key, String path) {
        Cookie cookies[] = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals(key)) {
                    Cookie cookie = new Cookie(key, "");//这边得用"",不能用null
                    cookie.setPath(path);//设置成跟写入cookies一样的
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }

    }

    /**
     * 获取cookie
     *
     * @param key
     * @return
     */
    public static String getCookie(HttpServletRequest request, String key) {
        logger.info("getCookies={}", JSONObject.toJSONString(request.getCookies()));
        Cookie[] cookies = request.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            Cookie c = cookies[i];
            if (c.getName().equalsIgnoreCase(key)) {
                return Escape.unescape(c.getValue());
            }
        }
        return null;
    }

    /**
     * 获取cookie(忽略大小写)
     *
     * @param request
     * @param key
     * @return
     */
    public static String getCookieWithoutEscape(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            Cookie c = cookies[i];
            if (c.getName().equalsIgnoreCase(key)) {
                return c.getValue();
            }
        }
        return null;
    }

    /**
     * 获取cookie
     *
     * @param request
     * @return
     */
    public static Cookie[] getCookieArray(HttpServletRequest request) {
        return request.getCookies();
    }
}
