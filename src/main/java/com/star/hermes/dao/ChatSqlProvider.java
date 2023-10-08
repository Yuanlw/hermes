package com.star.hermes.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.star.hermes.entity.Chat;

public class ChatSqlProvider {

    public String insertSelective(Chat record) {
        BEGIN();
        INSERT_INTO("t_chat");

        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }

        if (record.getType() != null) {
            VALUES("type", "#{type,jdbcType=INTEGER}");
        }

        if (record.getChatQ() != null) {
            VALUES("chat_q", "#{chatQ,jdbcType=VARCHAR}");
        }

        if (record.getChatA() != null) {
            VALUES("chat_a", "#{chatA,jdbcType=VARCHAR}");
        }

        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }

        return SQL();
    }

    public String updateByPrimaryKeySelective(Chat record) {
        BEGIN();
        UPDATE("t_chat");

        if (record.getUserId() != null) {
            SET("user_id = #{userId,jdbcType=INTEGER}");
        }

        if (record.getType() != null) {
            SET("type = #{type,jdbcType=INTEGER}");
        }

        if (record.getChatQ() != null) {
            SET("chat_q = #{chatQ,jdbcType=VARCHAR}");
        }

        if (record.getChatA() != null) {
            SET("chat_a = #{chatA,jdbcType=VARCHAR}");
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
