package org.lanqiao.mapper;

import org.lanqiao.entity.Article;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleMapper {
    int deleteByPrimaryKey(Integer articleId);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer articleId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}