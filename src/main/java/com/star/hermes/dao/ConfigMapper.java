package com.star.hermes.dao;

import com.star.hermes.entity.Config;
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

public interface ConfigMapper {
    @Delete({"delete from t_config", "where id = #{id,jdbcType=INTEGER}"})
    int deleteByPrimaryKey(Integer id);

    @Insert({"insert into t_config (user_id, sk, ", "subscribe_type, create_time, ", "update_time)", "values " +
              "(#{userId,jdbcType=INTEGER}, #{sk,jdbcType=VARCHAR}, ", "#{subscribeType,jdbcType=INTEGER}, " +
              "#{createTime,jdbcType=TIMESTAMP}, ", "#{updateTime,jdbcType=TIMESTAMP})"})
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(Config record);

    @InsertProvider(type = ConfigSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insertSelective(Config record);

    @Select({"select", "id, user_id, sk, subscribe_type, create_time, update_time", "from t_config", "where id = " +
              "#{id,jdbcType=INTEGER}"})
    @Results({@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true), @Result(column =
              "user_id", property = "userId", jdbcType = JdbcType.INTEGER), @Result(column = "sk", property = "sk",
              jdbcType = JdbcType.VARCHAR), @Result(column = "subscribe_type", property = "subscribeType", jdbcType =
              JdbcType.INTEGER), @Result(column = "create_time", property = "createTime", jdbcType =
              JdbcType.TIMESTAMP), @Result(column = "update_time", property = "updateTime", jdbcType =
              JdbcType.TIMESTAMP)})
    Config selectByPrimaryKey(Integer id);

    @UpdateProvider(type = ConfigSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Config record);

    @Update({"update t_config", "set user_id = #{userId,jdbcType=INTEGER},", "sk = #{sk,jdbcType=VARCHAR},",
              "subscribe_type = #{subscribeType,jdbcType=INTEGER},", "create_time = #{createTime,jdbcType=TIMESTAMP},"
              , "update_time = #{updateTime,jdbcType=TIMESTAMP}", "where id = #{id,jdbcType=INTEGER}"})
    int updateByPrimaryKey(Config record);
}
