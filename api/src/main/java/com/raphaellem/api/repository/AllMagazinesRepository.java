package com.raphaellem.api.repository;

import com.raphaellem.api.controller.ArticleController;
import com.raphaellem.api.controller.ThematiqueController;
import com.raphaellem.api.model.AllMagazines;
import com.raphaellem.api.model.Article;
import com.raphaellem.api.model.Magazine;
import com.raphaellem.api.model.Thematique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class AllMagazinesRepository {

    @Autowired
    private ArticleController articleController;

    @Autowired
    private ThematiqueController thematiqueController;

    public List<AllMagazines> getAllMagazines(Iterable<Magazine> magazines, Iterable<Article> articles, Date dateMagazine) {
        List<AllMagazines> allMagazinesList = new ArrayList<AllMagazines>();
        for (Article article: articles) {
            for (Magazine magazine : magazines) {
                if (article.getFkMagazine() == magazine.getId()) {
                    Optional<Thematique> respThematique = thematiqueController.getThematique(article.getFkThematique());
                    AllMagazines resp = new AllMagazines();
                    resp.setIdMagazine(magazine.getId());
                    resp.setDateMagazine(magazine.getPublication());
                    resp.setNomMagazine(magazine.getNom());
                    resp.setIdArticle(article.getId());
                    resp.setIdThematique(article.getFkThematique());
                    resp.setNomThematique(respThematique.get().getNom());
                    resp.setNomArticle(article.getTitre());
                    allMagazinesList.add(resp);
                }
            }
        }
        return allMagazinesList;
    }
}