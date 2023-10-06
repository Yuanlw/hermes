package com.star.hermes.enu;

/**
 * @ClassName BusinessTypeEnum
 * @Description TODO
 * @Author yuanlw
 * @Date 2023/9/12 15:27
 * @Version 1.0
 **/
public enum BusinessTypeEnum {

    FREE(0, "免费"),
    PAID(1, "付费");

    private Integer code;
    private String desc;

    BusinessTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
