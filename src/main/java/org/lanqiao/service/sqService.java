package org.lanqiao.service;



import org.lanqiao.entity.Article;

import java.util.List;


public interface sqService {

public  List<Article> getNowCityArticle(String cityName);

public String getUserName(Integer userId);


}
