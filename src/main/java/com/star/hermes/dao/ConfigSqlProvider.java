package com.star.hermes.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.star.hermes.entity.Config;

public class ConfigSqlProvider {

    public String insertSelective(Config record) {
        BEGIN();
        INSERT_INTO("t_config");

        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }

        if (record.getSk() != null) {
            VALUES("sk", "#{sk,jdbcType=VARCHAR}");
        }

        if (record.getSubscribeType() != null) {
            VALUES("subscribe_type", "#{subscribeType,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }

        return SQL();
    }

    public String updateByPrimaryKeySelective(Config record) {
        BEGIN();
        UPDATE("t_config");

        if (record.getUserId() != null) {
            SET("user_id = #{userId,jdbcType=INTEGER}");
        }

        if (record.getSk() != null) {
            SET("sk = #{sk,jdbcType=VARCHAR}");
        }

        if (record.getSubscribeType() != null) {
            SET("subscribe_type = #{subscribeType,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }

        WHERE("id = #{id,jdbcType=INTEGER}");

        return SQL();
    }
}
