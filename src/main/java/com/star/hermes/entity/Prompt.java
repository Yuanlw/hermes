package com.star.hermes.entity;

import java.util.Date;

public class Prompt {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String promptDesc;

    /**
     * 提示语
     */
    private String prompt;

    /**
     * 作者
     */
    private String author;

    /**
     * 审核 0未审核  1审核通过
     */
    private Integer checked;

    /**
     * 可用  1可用 0不可用
     */
    private Integer enable;

    /**
     * 排序权重
     */
    private Integer sort;

    /**
     * 参数列表(预设参数)
     */
    private String paramList;

    /**
     * 角色强化
     */
    private String promptRole;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPromptDesc() {
        return promptDesc;
    }

    public void setPromptDesc(String promptDesc) {
        this.promptDesc = promptDesc == null ? null : promptDesc.trim();
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt == null ? null : prompt.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getParamList() {
        return paramList;
    }

    public void setParamList(String paramList) {
        this.paramList = paramList == null ? null : paramList.trim();
    }

    public String getPromptRole() {
        return promptRole;
    }

    public void setPromptRole(String promptRole) {
        this.promptRole = promptRole == null ? null : promptRole.trim();
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