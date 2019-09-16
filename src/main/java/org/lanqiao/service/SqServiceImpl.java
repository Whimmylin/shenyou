package org.lanqiao.service;

import org.lanqiao.entity.Article;
import org.lanqiao.mapper.UserMapper;
import org.lanqiao.util.SolrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SqServiceImpl implements sqService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<Article> getNowCityArticle(String cityName){
        List<Article> articles =null;
        try {
             articles =  new SolrUtil().querySolr(cityName);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return articles;
        }
    }

    @Override
    public String getUserName(Integer userId) {
        return userMapper.selectUserNameByPK(userId);
    }
}
