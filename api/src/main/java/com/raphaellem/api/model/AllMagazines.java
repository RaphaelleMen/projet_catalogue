package com.raphaellem.api.model;

import lombok.Data;

import java.util.Date;

@Data
public class AllMagazines {

    Long idMagazine;

    Long idArticle;

    Long idThematique;

    String nomMagazine;

    public void setIdMagazine(Long idMagazine) {
        this.idMagazine = idMagazine;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }

    public void setIdThematique(Long idThematique) {
        this.idThematique = idThematique;
    }

    public void setNomMagazine(String nomMagazine) {
        this.nomMagazine = nomMagazine;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public void setNomThematique(String nomThematique) {
        this.nomThematique = nomThematique;
    }

    public void setDateMagazine(Date dateMagazine) {
        this.dateMagazine = dateMagazine;
    }

    String nomArticle;

    String nomThematique;

    Date dateMagazine;


}