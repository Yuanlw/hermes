package com.star.hermes.common;

/**
 * @ClassName RespCode
 * @Description TODO
 * @Author yuanlw
 * @Date 2023/9/12 14:34
 * @Version 1.0
 **/
public enum RespCode {

    SUCCESS(200, "成功"),
    FAIL(500, "请求失败"),
    UNAUTHORIZED(401, "Unauthorized"),
    INVALID_PARAM(601, "参数错误"),
    INVALID_REQUEST(602, ""),
    //    UNAUTHORIZED(603,""),
    FORBIDDEN(604, ""),
    NOT_FOUND(605, ""),
    INTERNAL_ERROR(606, "");

    private int code;
    private String msg;

    RespCode(int code) {
        this.code = code;
    }

    RespCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
