package com.star.hermes.common;

/**
 * 返回的封装实体
 *
 * @Author yuanlw
 **/
public class TcRespDto<T> {

    private int code;
    private T data;
    private String message;

    public static <T> TcRespDto<T> success(T data) {
        TcRespDto<T> resp = new TcRespDto<>();
        resp.setCode(200);
        resp.setData(data);
        resp.setMessage("成功");
        return resp;
    }

    public static <T> TcRespDto<T> success(String message) {
        TcRespDto<T> resp = new TcRespDto<>();
        resp.setCode(200);
        resp.setMessage(message);
        return resp;
    }

    public static <T> TcRespDto<T> fail(int code, String message) {
        TcRespDto<T> resp = new TcRespDto<>();
        resp.setCode(code);
        resp.setMessage(message);
        return resp;
    }

    public static <T> TcRespDto<T> success() {
        return success(null);
    }

    public static <T> TcRespDto<T> fail(String message) {
        return fail(RespCode.FAIL.getCode(), message);
    }

    public static <T> TcRespDto<T> invalidParam() {
        return fail(RespCode.INVALID_PARAM.getCode(), RespCode.INVALID_PARAM.getMsg());
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
