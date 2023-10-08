package com.star.hermes.dao;

import com.star.hermes.entity.UserPrompt;
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

public interface UserPromptMapper {
    @Delete({"delete from t_user_prompt", "where id = #{id,jdbcType=BIGINT}"})
    int deleteByPrimaryKey(Long id);

    @Insert({"insert into t_user_prompt (user_id, prompt_id, ", "sort, create_time)", "values (#{userId," +
              "jdbcType=BIGINT}, #{promptId,jdbcType=BIGINT}, ", "#{sort,jdbcType=INTEGER}, #{createTime," +
              "jdbcType=TIMESTAMP})"})
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(UserPrompt record);

    @InsertProvider(type = UserPromptSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insertSelective(UserPrompt record);

    @Select({"select", "id, user_id, prompt_id, sort, create_time", "from t_user_prompt", "where id = #{id," +
              "jdbcType=BIGINT}"})
    @Results({@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true), @Result(column =
              "user_id", property = "userId", jdbcType = JdbcType.BIGINT), @Result(column = "prompt_id", property =
              "promptId", jdbcType = JdbcType.BIGINT), @Result(column = "sort", property = "sort", jdbcType =
              JdbcType.INTEGER), @Result(column = "create_time", property = "createTime", jdbcType =
              JdbcType.TIMESTAMP)})
    UserPrompt selectByPrimaryKey(Long id);

    @UpdateProvider(type = UserPromptSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserPrompt record);

    @Update({"update t_user_prompt", "set user_id = #{userId,jdbcType=BIGINT},", "prompt_id = #{promptId," +
              "jdbcType=BIGINT},", "sort = #{sort,jdbcType=INTEGER},", "create_time = #{createTime," +
              "jdbcType=TIMESTAMP}", "where id = #{id,jdbcType=BIGINT}"})
    int updateByPrimaryKey(UserPrompt record);
}
