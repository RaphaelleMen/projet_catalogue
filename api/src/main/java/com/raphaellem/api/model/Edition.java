package com.raphaellem.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "maison_edition")
public class Edition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Adresse")
    private String adresse;

    @Column(name="Date_creation")
    private Date dateCreation;

    @Column(name="Nom")
    private String nom;

}
