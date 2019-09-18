package org.lanqiao.service;



import org.lanqiao.entity.Article;

import java.util.List;
import java.util.Set;


public interface sqService {

public  List<Article> getNowCityArticle(String cityName);

public String getUserName(Integer userId);

public void setHotCity(String cityName);

public Set getHotCity();

}
