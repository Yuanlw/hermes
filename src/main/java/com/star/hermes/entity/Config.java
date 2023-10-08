package com.star.hermes.entity;

import java.util.Date;

public class Config {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户的sk
     */
    private String sk;

    /**
     * 订阅类型
     */
    private Integer subscribeType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSk() {
        return sk;
    }

    public void setSk(String sk) {
        this.sk = sk == null ? null : sk.trim();
    }

    public Integer getSubscribeType() {
        return subscribeType;
    }

    public void setSubscribeType(Integer subscribeType) {
        this.subscribeType = subscribeType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}