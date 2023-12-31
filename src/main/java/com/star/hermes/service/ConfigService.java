package com.star.hermes.service;

import com.star.hermes.entity.Config;

import java.util.List;

/**
 * Description: ConfigService <br>
 * <p>
 * Do not edit this file It was auto-generated by Code-Generator
 *
 * @since 2023-10-8 16:54:26
 */
public interface ConfigService {

    /**
     * 新增
     *
     * @param config
     * @return
     */
    int save(Config config);

    /**
     * 更新操作
     *
     * @param config
     * @return
     */
    int update(Config config);

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
     * @param config
     * @return
     */
    int count(Config config);

    /**
     * 根据 id 查询信息
     *
     * @param id
     * @return
     */
    Config queryById(Long id);

    /**
     * 多条件查询返回集合
     *
     * @param config
     * @return
     */
    List<Config> queryList(Config config);

    /**
     * 分页多条件查询返回集合
     *
     * @param config
     * @param pageNum
     * @param countEachPage
     * @return
     */
    List<Config> queryPage(Config config, Integer pageNum, Integer countEachPage);
}
