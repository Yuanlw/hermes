package com.star.hermes.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.star.hermes.entity.User;

public class UserSqlProvider {

    public String insertSelective(User record) {
        BEGIN();
        INSERT_INTO("t_user");

        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }

        if (record.getUserPassword() != null) {
            VALUES("user_password", "#{userPassword,jdbcType=VARCHAR}");
        }

        if (record.getMail() != null) {
            VALUES("mail", "#{mail,jdbcType=VARCHAR}");
        }

        if (record.getBusinessType() != null) {
            VALUES("business_type", "#{businessType,jdbcType=INTEGER}");
        }

        if (record.getCount() != null) {
            VALUES("count", "#{count,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }

        return SQL();
    }

    public String updateByPrimaryKeySelective(User record) {
        BEGIN();
        UPDATE("t_user");

        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }

        if (record.getUserPassword() != null) {
            SET("user_password = #{userPassword,jdbcType=VARCHAR}");
        }

        if (record.getMail() != null) {
            SET("mail = #{mail,jdbcType=VARCHAR}");
        }

        if (record.getBusinessType() != null) {
            SET("business_type = #{businessType,jdbcType=INTEGER}");
        }

        if (record.getCount() != null) {
            SET("count = #{count,jdbcType=INTEGER}");
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
