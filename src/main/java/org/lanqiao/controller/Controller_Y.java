package org.lanqiao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.entity.Article;
import org.lanqiao.service.ArticlesServiceImpl;
import org.lanqiao.util.Base64;
import org.lanqiao.util.SaveTxt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.File;
import java.util.List;


@RestController
public class Controller_Y {

    @Autowired
    Base64 base64;
    @Autowired
    SaveTxt saveTxt;
    @Autowired
    ArticlesServiceImpl articlesService;

    @RequestMapping("/uploadPic")
    public String insert(String imageFile) {

        String path =  base64.base64(imageFile);
        System.out.println(path);
        return path;
    }
    @RequestMapping("deletePic")
    public void delete(String url){
        url= url.substring(url.lastIndexOf("/"));
        url = "file///root/" + url;
        File file = new File(url);
        if (file.exists()){
            file.delete();
        }
    }
    @RequestMapping("/uploadArticles")
    public int upload(String articles, @Valid Article article, String head){
        String url = saveTxt.saveAsFileWriter(articles);
        String path = base64.base64(head);
        article.setArticleAddress(url);
        article.setArticleImg(path);
        return articlesService.insertArticles(article);
    }

    @RequestMapping("/getAllArticles")
    public PageInfo get(@RequestParam(value = "pageNum", defaultValue = "2") Integer pageNum){

        PageHelper.startPage(pageNum, 3);

        List<Article> articleList = articlesService.getAllArticles();

        PageInfo<Article> pageInfo = new PageInfo<>(articleList);

        return pageInfo;
    }

    @RequestMapping("/getArticleDetails")
    public Article getArticleDetails(int articleId){
        Article article = articlesService.getArticleDetails(articleId);
        String content = saveTxt.turnFileTxt(article.getArticleAddress());
        article.setArticleAddress(content);
        return  article;
    }

    @RequestMapping("/selectBestArticles")
    public PageInfo selectBestArticles (@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, String isBest){

        PageHelper.startPage(pageNum, 3);

        List<Article> articleList = articlesService.selectBestArticles(isBest);

        PageInfo<Article> pageInfo = new PageInfo<>(articleList);

        return pageInfo;
    }
    @RequestMapping("/hot")
    public int updateHot(int articleId,int hot){

        return articlesService.updateHot(articleId,hot);

    }


}
