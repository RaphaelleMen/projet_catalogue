package com.raphaellem.api.service;

import com.raphaellem.api.controller.ArticleController;
import com.raphaellem.api.controller.MagazineController;
import com.raphaellem.api.model.AllMagazines;
import com.raphaellem.api.model.Article;
import com.raphaellem.api.model.Magazine;
import com.raphaellem.api.repository.AllMagazinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AllMagazinesService {

    @Autowired
    private AllMagazinesRepository allMagazinesRepository;

    @Autowired
    private ArticleController articleController;

    @Autowired
    private MagazineController magazineController;

    public List<AllMagazines> getAllMagazines(String nomMagazine, Long fkThematique, Date dateMagazine) {
        Iterable<Article> articles;
        if (fkThematique == null) {
            articles = articleController.getArticles();
        }
        else {
            articles = articleController.getArticlesByThematique(fkThematique);
        }
        Iterable<Magazine> magazines = magazineController.getMagazineNom(nomMagazine);
        return  allMagazinesRepository.getAllMagazines(magazines, articles, dateMagazine);
    }
}