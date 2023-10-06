/*
 * Copyright (c) 2015 daojia.com. All Rights Reserved.
 */
package com.star.hermes.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author
 * @description 上线文持有器
 * @since 1.0
 */
public class LocalContextHolder {
    private static final Logger logger = LoggerFactory.getLogger(LocalContextHolder.class);

    /**
     * 上线文线程变量
     */
    private final static ThreadLocal<LocalContext> contextThreadLocal = new ThreadLocal<LocalContext>();

    /**
     * 设置本地上下文
     *
     * @param localContext
     */
    public static void set(LocalContext localContext) {
        contextThreadLocal.set(localContext);
    }

    /**
     * 设置上下文
     *
     * @param request
     * @param response
     * @param model
     */
    public static void set(HttpServletRequest request, HttpServletResponse response, Model model) {
        set(new LocalContext(request, response, model));
    }

    /**
     * 获取本地上下文
     *
     * @return
     */
    public static LocalContext get() {
        return contextThreadLocal.get();
    }

    /**
     * 移除本地上下文
     */
    public static void remove() {
        contextThreadLocal.remove();
    }

    /**
     * 获取当前线程的request对象
     */
    public static HttpServletRequest getRequest() {
        if (get() != null) {
            logger.info("getRequest={}", get().getRequest().getHeader("buid"));
            return get().getRequest();
        }
        throw new LocalContextException("HttpServletRequest in  local context have be removed.");
    }

    /**
     * 获取当前线程的response对象
     */
    public static HttpServletResponse getResponse() {
        if (get() != null) {
            return get().getResponse();
        }
        throw new LocalContextException("HttpServletResponse in  local context have be removed.");
    }

    /**
     * 获取当前线程的model对象
     */
    public static Model getModel() {
        if (get() != null) {
            return get().getModel();
        }
        throw new LocalContextException("Model in  local context have be removed.");
    }

}
