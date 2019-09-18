package org.lanqiao.controller;

import org.lanqiao.service.sqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class sqController {

    @Autowired
    sqService sqService;

    @RequestMapping("/getNowA")
    public List getNowCityA(@RequestParam(defaultValue = "厦门") String cityName){
        return sqService.getNowCityArticle(cityName);
    }
    @RequestMapping("/getUserName")
    public String getUserName(int userid){
        return sqService.getUserName(userid);
    }

    @RequestMapping("/setHot")
    public void setHotCity(@RequestParam(defaultValue = "深圳市")String cityName){
        sqService.setHotCity(cityName);
    }

    @RequestMapping("/getHot")
    public Set getHotCity(){
        return sqService.getHotCity();
    }




}
