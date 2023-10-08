package com.star.hermes.entity;

import java.util.Date;

public class Business {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 次数
     */
    private Integer count;

    /**
     * 类型，1默认捐赠; 2月度；3年度；
     */
    private Integer businessType;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 支付金额
     */
    private Long payMoney;

    /**
     * 有效时间
     */
    private Date activityTime;

    /**
     * 创建时间
     */
    private Date creteTime;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Long getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Long payMoney) {
        this.payMoney = payMoney;
    }

    public Date getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    public Date getCreteTime() {
        return creteTime;
    }

    public void setCreteTime(Date creteTime) {
        this.creteTime = creteTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}