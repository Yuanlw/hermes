package com.star.hermes.dao;

import com.star.hermes.entity.Business;
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

public interface BusinessMapper {
    @Delete({"delete from t_business", "where id = #{id,jdbcType=BIGINT}"})
    int deleteByPrimaryKey(Long id);

    @Insert({"insert into t_business (user_id, count, ", "business_type, pay_time, ", "pay_money, activity_time, ",
              "crete_time, update_time)", "values (#{userId,jdbcType=BIGINT}, #{count,jdbcType=INTEGER}, ",
              "#{businessType,jdbcType=INTEGER}, #{payTime,jdbcType=TIMESTAMP}, ", "#{payMoney,jdbcType=DECIMAL}, " +
              "#{activityTime,jdbcType=TIMESTAMP}, ", "#{creteTime,jdbcType=TIMESTAMP}, #{updateTime," +
              "jdbcType=TIMESTAMP})"})
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(Business record);

    @InsertProvider(type = BusinessSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insertSelective(Business record);

    @Select({"select", "id, user_id, count, business_type, pay_time, pay_money, activity_time, crete_time, ",
              "update_time", "from t_business", "where id = #{id,jdbcType=BIGINT}"})
    @Results({@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true), @Result(column =
              "user_id", property = "userId", jdbcType = JdbcType.BIGINT), @Result(column = "count", property =
              "count", jdbcType = JdbcType.INTEGER), @Result(column = "business_type", property = "businessType",
              jdbcType = JdbcType.INTEGER), @Result(column = "pay_time", property = "payTime", jdbcType =
              JdbcType.TIMESTAMP), @Result(column = "pay_money", property = "payMoney", jdbcType = JdbcType.DECIMAL),
              @Result(column = "activity_time", property = "activityTime", jdbcType = JdbcType.TIMESTAMP),
              @Result(column = "crete_time", property = "creteTime", jdbcType = JdbcType.TIMESTAMP), @Result(column =
              "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)})
    Business selectByPrimaryKey(Long id);

    @UpdateProvider(type = BusinessSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Business record);

    @Update({"update t_business", "set user_id = #{userId,jdbcType=BIGINT},", "count = #{count,jdbcType=INTEGER},",
              "business_type = #{businessType,jdbcType=INTEGER},", "pay_time = #{payTime,jdbcType=TIMESTAMP},",
              "pay_money = #{payMoney,jdbcType=DECIMAL},", "activity_time = #{activityTime,jdbcType=TIMESTAMP},",
              "crete_time = #{creteTime,jdbcType=TIMESTAMP},", "update_time = #{updateTime,jdbcType=TIMESTAMP}",
              "where id = #{id,jdbcType=BIGINT}"})
    int updateByPrimaryKey(Business record);
}
