package com.star.hermes.service.impl;

import com.star.hermes.entity.Config;
import com.star.hermes.ext.ConfigExtDao;
import com.star.hermes.service.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: ConfigServiceImpl <br>
 * <p>
 * Do not edit this file It was auto-generated by Code-Generator
 *
 * @since 2023-10-8 16:54:26
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    private static final Logger logger = LoggerFactory.getLogger(ConfigServiceImpl.class);

    @Resource
    private ConfigExtDao configExtDao;

    @Override
    public int save(Config config) {
        return configExtDao.insertSelective(config);
    }

    @Override
    public int update(Config config) {
        return configExtDao.updateByPrimaryKeySelective(config);
    }

    @Override
    public int delete(Long id) {
        return configExtDao.deleteByPrimaryKey(id);
    }

    @Override
    public int count(Config config) {
        return 0;
    }

    @Override
    public Config queryById(Long id) {
        return null;
    }

    @Override
    public List<Config> queryList(Config config) {
        return null;
    }

    @Override
    public List<Config> queryPage(Config config, Integer pageNum, Integer countEachPage) {
        return null;
    }

    //    @Override
    //    public int count(Config config){
    //        return configExtDao.queryForCount(config);
    //    }
    //
    //    @Override
    //    public Config queryById(Long id) {
    //        return configExtDao.selectByPrimaryKey(id);
    //    }
    //
    //    @Override
    //    public List<Config> queryList(Config config) {
    //        return configExtDao.queryForList(config, null);
    //    }
    //
    //    @Override
    //    public List<Config> queryPage(Config config, Integer pageNum, Integer countEachPage){
    //        return configExtDao.queryForList(config, PageUtil.initPage(pageNum, countEachPage));
    //    }
}
