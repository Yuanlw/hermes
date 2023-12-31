package com.star.hermes.service;

import com.star.hermes.entity.Chat;

import java.util.List;

/**
 * Description: ChatService <br>
 * <p>
 * Do not edit this file It was auto-generated by Code-Generator
 *
 * @since 2023-10-8 16:54:26
 */
public interface ChatService {

    /**
     * 新增
     *
     * @param chat
     * @return
     */
    int save(Chat chat);

    /**
     * 更新操作
     *
     * @param chat
     * @return
     */
    int update(Chat chat);

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
     * @param chat
     * @return
     */
    int count(Chat chat);

    /**
     * 根据 id 查询信息
     *
     * @param id
     * @return
     */
    Chat queryById(Long id);

    /**
     * 多条件查询返回集合
     *
     * @param chat
     * @return
     */
    List<Chat> queryList(Chat chat);

    /**
     * 分页多条件查询返回集合
     *
     * @param chat
     * @param pageNum
     * @param countEachPage
     * @return
     */
    List<Chat> queryPage(Chat chat, Integer pageNum, Integer countEachPage);
}
