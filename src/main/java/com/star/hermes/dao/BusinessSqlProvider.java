package com.star.hermes.dao;

import com.star.hermes.entity.Business;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class BusinessSqlProvider {

    public String insertSelective(Business record) {
        BEGIN();
        INSERT_INTO("t_business");

        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }

        if (record.getCount() != null) {
            VALUES("count", "#{count,jdbcType=INTEGER}");
        }

        if (record.getBusinessType() != null) {
            VALUES("business_type", "#{businessType,jdbcType=INTEGER}");
        }

        if (record.getPayTime() != null) {
            VALUES("pay_time", "#{payTime,jdbcType=TIMESTAMP}");
        }

        if (record.getPayMoney() != null) {
            VALUES("pay_money", "#{payMoney,jdbcType=DECIMAL}");
        }

        if (record.getActivityTime() != null) {
            VALUES("activity_time", "#{activityTime,jdbcType=TIMESTAMP}");
        }

        if (record.getCreteTime() != null) {
            VALUES("crete_time", "#{creteTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }

        return SQL();
    }

    public String updateByPrimaryKeySelective(Business record) {
        BEGIN();
        UPDATE("t_business");

        if (record.getUserId() != null) {
            SET("user_id = #{userId,jdbcType=BIGINT}");
        }

        if (record.getCount() != null) {
            SET("count = #{count,jdbcType=INTEGER}");
        }

        if (record.getBusinessType() != null) {
            SET("business_type = #{businessType,jdbcType=INTEGER}");
        }

        if (record.getPayTime() != null) {
            SET("pay_time = #{payTime,jdbcType=TIMESTAMP}");
        }

        if (record.getPayMoney() != null) {
            SET("pay_money = #{payMoney,jdbcType=DECIMAL}");
        }

        if (record.getActivityTime() != null) {
            SET("activity_time = #{activityTime,jdbcType=TIMESTAMP}");
        }

        if (record.getCreteTime() != null) {
            SET("crete_time = #{creteTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }

        WHERE("id = #{id,jdbcType=BIGINT}");

        return SQL();
    }
}
