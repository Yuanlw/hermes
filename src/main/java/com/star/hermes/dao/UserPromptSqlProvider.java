package com.star.hermes.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.star.hermes.entity.UserPrompt;

public class UserPromptSqlProvider {

    public String insertSelective(UserPrompt record) {
        BEGIN();
        INSERT_INTO("t_user_prompt");

        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }

        if (record.getPromptId() != null) {
            VALUES("prompt_id", "#{promptId,jdbcType=BIGINT}");
        }

        if (record.getSort() != null) {
            VALUES("sort", "#{sort,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }

        return SQL();
    }

    public String updateByPrimaryKeySelective(UserPrompt record) {
        BEGIN();
        UPDATE("t_user_prompt");

        if (record.getUserId() != null) {
            SET("user_id = #{userId,jdbcType=BIGINT}");
        }

        if (record.getPromptId() != null) {
            SET("prompt_id = #{promptId,jdbcType=BIGINT}");
        }

        if (record.getSort() != null) {
            SET("sort = #{sort,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }

        WHERE("id = #{id,jdbcType=BIGINT}");

        return SQL();
    }
}
