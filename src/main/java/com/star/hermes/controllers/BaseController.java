package com.star.hermes.controllers;

import com.alibaba.fastjson2.JSONObject;
import com.star.hermes.common.RespCode;
import com.star.hermes.common.TcRespDto;
import com.star.hermes.util.CookieUtil;
import com.star.hermes.util.LocalContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * TODO
 *
 * @Author yuanlw
 **/
public class BaseController {
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    public static final String USER_AGENT = "user-agent";
    public final static String WINDOWS_NT = "Windows NT";
    private final static String[] client = {"Android", "iPhone", "iPod", "Windows Phone", "MQQBrowser"};
    //定义移动端请求的所有可能类型

    /**
     * 判断User-Agent 是不是来自于手机
     *
     * @param ua
     * @return
     */
    protected static boolean checkClientIsMobile(String ua) {
        boolean flag = false;
        if (!ua.contains(WINDOWS_NT) || (ua.contains(WINDOWS_NT) && ua.contains("compatible; MSIE 9.0;"))) {
            // 排除 苹果桌面系统
            if (!ua.contains(WINDOWS_NT) && !ua.contains("Macintosh")) {
                for (String item : client) {
                    if (ua.contains(item)) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        return flag;
    }

    /**
     * 判断微信环境
     *
     * @return
     */
    public boolean isWeixin() {
        if (getRequest().getHeader(USER_AGENT) == null) {
            return false;
        }
        String userAgent = getRequest().getHeader(USER_AGENT).toLowerCase();
        return userAgent.contains("micromessenger");
    }

    /**
     * 从cookie获取值
     *
     * @param name
     * @return
     */
    public String getCookie(String name) {
        return CookieUtil.getCookie(getRequest(), name);
    }

    /**
     * 设置cookie参数
     *
     * @param name
     * @param value
     */
    public void setCookie(String name, Object value) {
        if (value == null) {
            return;
        }
        CookieUtil.writeCookie(getResponse(), name, value.toString(), CookieUtil.EXPIRE_TIME_DEFAULT);
    }

    /**
     * cookie删除某个值
     *
     * @param key
     */
    public void removeCookie(String key) {
        CookieUtil.removeCookie(getRequest(), getResponse(), key);
        return;
    }

    /**
     * 获取uid
     *
     * @return
     */
    public Long getUid() {
        String uid = getRequest().getHeader("buid");
        logger.info("get request attribute uid:{}", uid);
        try {
            if (uid != null && !uid.toString().equalsIgnoreCase("-1")) {
                return Long.parseLong(uid.toString());
            } else {
                String uid1 = getRequest().getParameter("userId");
                return uid1 != null && !uid1.equalsIgnoreCase("-1") ? Long.parseLong(uid1) : -1L;
            }
        } catch (Exception ex) {
            logger.error("get request attribute uid error !", ex);
            return -1L;
        }
    }

    /**
     * url中获取参数,以map返回
     *
     * @return Map
     */
    public Map<String, String> getParameterMap() {
        Map<String, String> params = new HashMap<String, String>();
        try {
            Map<String, String[]> requestParams = getRequest().getParameterMap();
            for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
                String name = (String) iter.next();
                String[] values = requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
                }
                params.put(name, valueStr);
            }
        } catch (Exception e) {
            logger.error("getParameterMap:getParameterMap出错," + e);
        }
        logger.info("获取url中参数：params=", JSONObject.toJSONString(params));
        return params;
    }

    public TcRespDto checkUid(Long uid) {
        TcRespDto respDto = new TcRespDto();
        Long checkUid = Long.valueOf(CookieUtil.getCookie(getRequest(), "buid"));
        if (uid == null || uid == -1 || checkUid.intValue() != uid.intValue()) {
            respDto = TcRespDto.fail(RespCode.UNAUTHORIZED.getCode(), RespCode.UNAUTHORIZED.getMsg());
        }
        return respDto;
    }

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response, Model model) {
        LocalContextHolder.set(request, response, model);
    }

    protected HttpServletRequest getRequest() {
        return LocalContextHolder.getRequest();
    }

    protected HttpServletResponse getResponse() {
        return LocalContextHolder.getResponse();
    }
}
