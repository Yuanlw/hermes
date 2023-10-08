package com.star.hermes.dao;

import com.star.hermes.entity.Chat;
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

public interface ChatMapper {
    @Delete({"delete from t_chat", "where id = #{id,jdbcType=INTEGER}"})
    int deleteByPrimaryKey(Integer id);

    @Insert({"insert into t_chat (user_id, type, ", "chat_q, chat_a, create_time, ", "update_time)", "values " +
              "(#{userId,jdbcType=INTEGER}, #{type,jdbcType=INTEGER}, ", "#{chatQ,jdbcType=VARCHAR}, #{chatA," +
              "jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ", "#{updateTime,jdbcType=TIMESTAMP})"})
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(Chat record);

    @InsertProvider(type = ChatSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insertSelective(Chat record);

    @Select({"select", "id, user_id, type, chat_q, chat_a, create_time, update_time", "from t_chat", "where id = " +
              "#{id,jdbcType=INTEGER}"})
    @Results({@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true), @Result(column =
              "user_id", property = "userId", jdbcType = JdbcType.INTEGER), @Result(column = "type", property = "type"
              , jdbcType = JdbcType.INTEGER), @Result(column = "chat_q", property = "chatQ", jdbcType =
              JdbcType.VARCHAR), @Result(column = "chat_a", property = "chatA", jdbcType = JdbcType.VARCHAR),
              @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
              @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)})
    Chat selectByPrimaryKey(Integer id);

    @UpdateProvider(type = ChatSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Chat record);

    @Update({"update t_chat", "set user_id = #{userId,jdbcType=INTEGER},", "type = #{type,jdbcType=INTEGER},",
              "chat_q = #{chatQ,jdbcType=VARCHAR},", "chat_a = #{chatA,jdbcType=VARCHAR},", "create_time = " +
              "#{createTime,jdbcType=TIMESTAMP},", "update_time = #{updateTime,jdbcType=TIMESTAMP}", "where id = " +
              "#{id,jdbcType=INTEGER}"})
    int updateByPrimaryKey(Chat record);
}
