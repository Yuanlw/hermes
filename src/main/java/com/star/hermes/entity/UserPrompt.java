package com.star.hermes.entity;

import java.util.Date;

public class UserPrompt {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 提示词ID
     */
    private Long promptId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPromptId() {
        return promptId;
    }

    public void setPromptId(Long promptId) {
        this.promptId = promptId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}