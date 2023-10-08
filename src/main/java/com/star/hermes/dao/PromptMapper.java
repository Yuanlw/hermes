package com.star.hermes.dao;

import com.star.hermes.entity.Prompt;
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

public interface PromptMapper {
    @Delete({"delete from t_prompt", "where id = #{id,jdbcType=BIGINT}"})
    int deleteByPrimaryKey(Long id);

    @Insert({"insert into t_prompt (title, prompt_desc, ", "prompt, author, ", "checked, enable, ", "sort, " +
              "param_list, ", "prompt_role, create_time, ", "update_time)", "values (#{title,jdbcType=VARCHAR}, " +
              "#{promptDesc,jdbcType=VARCHAR}, ", "#{prompt,jdbcType=VARCHAR}, #{author,jdbcType=VARCHAR}, ",
              "#{checked,jdbcType=INTEGER}, #{enable,jdbcType=INTEGER}, ", "#{sort,jdbcType=INTEGER}, #{paramList," +
              "jdbcType=VARCHAR}, ", "#{promptRole,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
              "#{updateTime,jdbcType=TIMESTAMP})"})
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(Prompt record);

    @InsertProvider(type = PromptSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insertSelective(Prompt record);

    @Select({"select", "id, title, prompt_desc, prompt, author, checked, enable, sort, param_list, prompt_role, ",
              "create_time, update_time", "from t_prompt", "where id = #{id,jdbcType=BIGINT}"})
    @Results({@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true), @Result(column = "title"
              , property = "title", jdbcType = JdbcType.VARCHAR), @Result(column = "prompt_desc", property =
              "promptDesc", jdbcType = JdbcType.VARCHAR), @Result(column = "prompt", property = "prompt", jdbcType =
              JdbcType.VARCHAR), @Result(column = "author", property = "author", jdbcType = JdbcType.VARCHAR),
              @Result(column = "checked", property = "checked", jdbcType = JdbcType.INTEGER), @Result(column =
              "enable", property = "enable", jdbcType = JdbcType.INTEGER), @Result(column = "sort", property = "sort"
              , jdbcType = JdbcType.INTEGER), @Result(column = "param_list", property = "paramList", jdbcType =
              JdbcType.VARCHAR), @Result(column = "prompt_role", property = "promptRole",
              jdbcType = JdbcType.VARCHAR), @Result(column = "create_time", property = "createTime", jdbcType =
              JdbcType.TIMESTAMP), @Result(column = "update_time", property = "updateTime", jdbcType =
              JdbcType.TIMESTAMP)})
    Prompt selectByPrimaryKey(Long id);

    @UpdateProvider(type = PromptSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Prompt record);

    @Update({"update t_prompt", "set title = #{title,jdbcType=VARCHAR},", "prompt_desc = #{promptDesc," +
              "jdbcType=VARCHAR},", "prompt = #{prompt,jdbcType=VARCHAR},", "author = #{author,jdbcType=VARCHAR},",
              "checked = #{checked,jdbcType=INTEGER},", "enable = #{enable,jdbcType=INTEGER},", "sort = #{sort," +
              "jdbcType=INTEGER},", "param_list = #{paramList,jdbcType=VARCHAR},", "prompt_role = #{promptRole," +
              "jdbcType=VARCHAR},", "create_time = #{createTime,jdbcType=TIMESTAMP},", "update_time = #{updateTime," +
              "jdbcType=TIMESTAMP}", "where id = #{id,jdbcType=BIGINT}"})
    int updateByPrimaryKey(Prompt record);
}
