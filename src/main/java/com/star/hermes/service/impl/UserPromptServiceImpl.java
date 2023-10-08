package com.star.hermes.service.impl;

import com.star.hermes.entity.UserPrompt;
import com.star.hermes.ext.UserPromptExtDao;
import com.star.hermes.service.UserPromptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: UserPromptServiceImpl <br>
 * <p>
 * Do not edit this file It was auto-generated by Code-Generator
 *
 * @since 2023-10-8 16:54:27
 */
@Service
public class UserPromptServiceImpl implements UserPromptService {

    private static final Logger logger = LoggerFactory.getLogger(UserPromptServiceImpl.class);

    @Resource
    private UserPromptExtDao userPromptExtDao;

    @Override
    public int save(UserPrompt userPrompt) {
        return userPromptExtDao.insertSelective(userPrompt);
    }

    @Override
    public int update(UserPrompt userPrompt) {
        return userPromptExtDao.updateByPrimaryKeySelective(userPrompt);
    }

    @Override
    public int delete(Long id) {
        return userPromptExtDao.deleteByPrimaryKey(id);
    }

    @Override
    public int count(UserPrompt userPrompt) {
        return 0;
    }

    @Override
    public UserPrompt queryById(Long id) {
        return null;
    }

    @Override
    public List<UserPrompt> queryList(UserPrompt userPrompt) {
        return null;
    }

    @Override
    public List<UserPrompt> queryPage(UserPrompt userPrompt, Integer pageNum, Integer countEachPage) {
        return null;
    }

    //    @Override
    //    public int count(UserPrompt userPrompt){
    //        return userPromptExtDao.queryForCount(userPrompt);
    //    }
    //
    //    @Override
    //    public UserPrompt queryById(Long id) {
    //        return userPromptExtDao.selectByPrimaryKey(id);
    //    }
    //
    //    @Override
    //    public List<UserPrompt> queryList(UserPrompt userPrompt) {
    //        return userPromptExtDao.queryForList(userPrompt, null);
    //    }
    //
    //    @Override
    //    public List<UserPrompt> queryPage(UserPrompt userPrompt, Integer pageNum, Integer countEachPage){
    //        return userPromptExtDao.queryForList(userPrompt, PageUtil.initPage(pageNum, countEachPage));
    //    }
}