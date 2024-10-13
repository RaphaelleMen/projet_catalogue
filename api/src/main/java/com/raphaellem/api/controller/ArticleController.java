package com.raphaellem.api.controller;

import com.raphaellem.api.model.Article;
import com.raphaellem.api.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:9300/")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public Iterable<Article> getArticles(){
        return articleService.getArticles();
    }

    @GetMapping("/article/{id}")
    public Optional<Article> getArticle(@PathVariable Long id){
        return articleService.getArticle(id);
    }

    @DeleteMapping("/article/{id}")
    public void deleteArticle(@PathVariable Long id){
        articleService.deleteArticle(id);
    }

    @PutMapping("/article")
    public Article updateArticle(@RequestBody Article article){
        return articleService.updateArticle(article);
    }

    @PostMapping("/article")
    public Article createArticle(@RequestBody Article article){
        return articleService.createArticle(article);
    }
    @GetMapping("/articleByThematique/{thematiqueId}")
    public Iterable<Article> getArticlesByThematique(@PathVariable Long thematiqueId) {
        return articleService.getArticlesByThematique(thematiqueId);
    }
}
