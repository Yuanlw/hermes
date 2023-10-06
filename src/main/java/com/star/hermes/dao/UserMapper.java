package com.star.hermes.dao;

import com.star.hermes.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @Delete({"delete from t_user", "where id = #{id,jdbcType=BIGINT}"})
    int deleteByPrimaryKey(Long id);

    @Insert({"insert into t_user (name, user_password, ", "mail, business_type, ", "count, create_time, ",
              "update_time)", "values (#{name,jdbcType=VARCHAR}, #{userPassword,jdbcType=VARCHAR}, ", "#{mail," +
              "jdbcType=VARCHAR}, #{businessType,jdbcType=INTEGER}, ", "#{count,jdbcType=INTEGER}, #{createTime," +
              "jdbcType=TIMESTAMP}, ", "#{updateTime,jdbcType=TIMESTAMP})"})
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(User record);

    @InsertProvider(type = UserSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insertSelective(User record);

    @Select({"select", "id, name, user_password, mail, business_type, count, create_time, update_time", "from t_user"
              , "where id = #{id,jdbcType=BIGINT}"})
    @Results({@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true), @Result(column = "name"
              , property = "name", jdbcType = JdbcType.VARCHAR), @Result(column = "user_password", property =
              "userPassword", jdbcType = JdbcType.VARCHAR), @Result(column = "mail", property = "mail", jdbcType =
              JdbcType.VARCHAR), @Result(column = "business_type", property = "businessType", jdbcType =
              JdbcType.INTEGER), @Result(column = "count", property = "count", jdbcType = JdbcType.INTEGER),
              @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
              @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)})
    User selectByPrimaryKey(Long id);

    @UpdateProvider(type = UserSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({"update t_user", "set name = #{name,jdbcType=VARCHAR},", "user_password = #{userPassword," +
              "jdbcType=VARCHAR},", "mail = #{mail,jdbcType=VARCHAR},", "business_type = #{businessType," +
              "jdbcType=INTEGER},", "count = #{count,jdbcType=INTEGER},", "create_time = #{createTime," +
              "jdbcType=TIMESTAMP},", "update_time = #{updateTime,jdbcType=TIMESTAMP}", "where id = #{id," +
              "jdbcType=BIGINT}"})
    int updateByPrimaryKey(User record);
}
