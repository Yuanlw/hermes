package com.star.hermes.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.star.hermes.entity.Prompt;

public class PromptSqlProvider {

    public String insertSelective(Prompt record) {
        BEGIN();
        INSERT_INTO("t_prompt");

        if (record.getTitle() != null) {
            VALUES("title", "#{title,jdbcType=VARCHAR}");
        }

        if (record.getPromptDesc() != null) {
            VALUES("prompt_desc", "#{promptDesc,jdbcType=VARCHAR}");
        }

        if (record.getPrompt() != null) {
            VALUES("prompt", "#{prompt,jdbcType=VARCHAR}");
        }

        if (record.getAuthor() != null) {
            VALUES("author", "#{author,jdbcType=VARCHAR}");
        }

        if (record.getChecked() != null) {
            VALUES("checked", "#{checked,jdbcType=INTEGER}");
        }

        if (record.getEnable() != null) {
            VALUES("enable", "#{enable,jdbcType=INTEGER}");
        }

        if (record.getSort() != null) {
            VALUES("sort", "#{sort,jdbcType=INTEGER}");
        }

        if (record.getParamList() != null) {
            VALUES("param_list", "#{paramList,jdbcType=VARCHAR}");
        }

        if (record.getPromptRole() != null) {
            VALUES("prompt_role", "#{promptRole,jdbcType=VARCHAR}");
        }

        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }

        return SQL();
    }

    public String updateByPrimaryKeySelective(Prompt record) {
        BEGIN();
        UPDATE("t_prompt");

        if (record.getTitle() != null) {
            SET("title = #{title,jdbcType=VARCHAR}");
        }

        if (record.getPromptDesc() != null) {
            SET("prompt_desc = #{promptDesc,jdbcType=VARCHAR}");
        }

        if (record.getPrompt() != null) {
            SET("prompt = #{prompt,jdbcType=VARCHAR}");
        }

        if (record.getAuthor() != null) {
            SET("author = #{author,jdbcType=VARCHAR}");
        }

        if (record.getChecked() != null) {
            SET("checked = #{checked,jdbcType=INTEGER}");
        }

        if (record.getEnable() != null) {
            SET("enable = #{enable,jdbcType=INTEGER}");
        }

        if (record.getSort() != null) {
            SET("sort = #{sort,jdbcType=INTEGER}");
        }

        if (record.getParamList() != null) {
            SET("param_list = #{paramList,jdbcType=VARCHAR}");
        }

        if (record.getPromptRole() != null) {
            SET("prompt_role = #{promptRole,jdbcType=VARCHAR}");
        }

        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }

        WHERE("id = #{id,jdbcType=BIGINT}");

        return SQL();
    }
}
