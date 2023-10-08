package com.star.hermes.service.impl;

import com.star.hermes.entity.Prompt;
import com.star.hermes.ext.PromptExtDao;
import com.star.hermes.service.PromptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: PromptServiceImpl <br>
 * <p>
 * Do not edit this file It was auto-generated by Code-Generator
 *
 * @since 2023-10-8 16:54:27
 */
@Service
public class PromptServiceImpl implements PromptService {

    private static final Logger logger = LoggerFactory.getLogger(PromptServiceImpl.class);

    @Resource
    private PromptExtDao promptExtDao;

    @Override
    public int save(Prompt prompt) {
        return promptExtDao.insertSelective(prompt);
    }

    @Override
    public int update(Prompt prompt) {
        return promptExtDao.updateByPrimaryKeySelective(prompt);
    }

    @Override
    public int delete(Long id) {
        return promptExtDao.deleteByPrimaryKey(id);
    }

    @Override
    public int count(Prompt prompt) {
        return 0;
    }

    @Override
    public Prompt queryById(Long id) {
        return null;
    }

    @Override
    public List<Prompt> queryList(Prompt prompt) {
        return null;
    }

    @Override
    public List<Prompt> queryPage(Prompt prompt, Integer pageNum, Integer countEachPage) {
        return null;
    }

    //    @Override
    //    public int count(Prompt prompt){
    //        return promptExtDao.queryForCount(prompt);
    //    }
    //
    //    @Override
    //    public Prompt queryById(Long id) {
    //        return promptExtDao.selectByPrimaryKey(id);
    //    }
    //
    //    @Override
    //    public List<Prompt> queryList(Prompt prompt) {
    //        return promptExtDao.queryForList(prompt, null);
    //    }
    //
    //    @Override
    //    public List<Prompt> queryPage(Prompt prompt, Integer pageNum, Integer countEachPage){
    //        return promptExtDao.queryForList(prompt, PageUtil.initPage(pageNum, countEachPage));
    //    }
}
