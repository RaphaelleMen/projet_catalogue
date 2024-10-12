package com.raphaellem.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "thematiques")
public class Thematique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Nom")
    private String nom;

}
