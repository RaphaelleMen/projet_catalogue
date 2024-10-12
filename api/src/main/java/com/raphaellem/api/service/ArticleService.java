package com.raphaellem.api.service;

import com.raphaellem.api.model.Article;
import com.raphaellem.api.repository.ArticleRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Optional<Article> getArticle(final Long id){
        return articleRepository.findById(id);
    }

    public Iterable<Article> getArticles(){
        return articleRepository.findAll();
    }

    public void deleteArticle(final Long id){
        articleRepository.deleteById(id);
    }

    public Article updateArticle(Article article){
        Article updatedArticle = articleRepository.save(article);
        return  updatedArticle;
    }

    public Article createArticle(Article article){
        Article createdArticle = articleRepository.save(article);
        return  createdArticle;
    }

}
