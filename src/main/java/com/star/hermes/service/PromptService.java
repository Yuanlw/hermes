package com.star.hermes.service;

import com.star.hermes.entity.Prompt;

import java.util.List;

/**
 * Description: PromptService <br>
 * <p>
 * Do not edit this file It was auto-generated by Code-Generator
 *
 * @since 2023-10-8 16:54:27
 */
public interface PromptService {

    /**
     * 新增
     *
     * @param prompt
     * @return
     */
    int save(Prompt prompt);

    /**
     * 更新操作
     *
     * @param prompt
     * @return
     */
    int update(Prompt prompt);

    /**
     * 物理删除操作
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 查询数量
     *
     * @param prompt
     * @return
     */
    int count(Prompt prompt);

    /**
     * 根据 id 查询信息
     *
     * @param id
     * @return
     */
    Prompt queryById(Long id);

    /**
     * 多条件查询返回集合
     *
     * @param prompt
     * @return
     */
    List<Prompt> queryList(Prompt prompt);

    /**
     * 分页多条件查询返回集合
     *
     * @param prompt
     * @param pageNum
     * @param countEachPage
     * @return
     */
    List<Prompt> queryPage(Prompt prompt, Integer pageNum, Integer countEachPage);
}