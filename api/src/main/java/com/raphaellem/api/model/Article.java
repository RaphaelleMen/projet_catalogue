package com.raphaellem.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Titre")
    private String titre;

    @Column(name="Auteur")
    private String auteur;

    @Column(name="Texte")
    private String texte;

    @Column(name="Image")
    private String image;

    @Column(name="fk_magazine")
    private Long fkMagazine;

    @Column(name="fk_thematique")
    private Long fkThematique;

}
