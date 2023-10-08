package com.star.hermes.entity;

import java.util.Date;

public class Chat {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 对话类型
     */
    private Integer type;

    /**
     * 用户问题
     */
    private String chatQ;

    /**
     * AI回答
     */
    private String chatA;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getChatQ() {
        return chatQ;
    }

    public void setChatQ(String chatQ) {
        this.chatQ = chatQ == null ? null : chatQ.trim();
    }

    public String getChatA() {
        return chatA;
    }

    public void setChatA(String chatA) {
        this.chatA = chatA == null ? null : chatA.trim();
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