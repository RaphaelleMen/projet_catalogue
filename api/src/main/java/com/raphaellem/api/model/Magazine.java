package com.raphaellem.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "magazines")
public class Magazine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Nom")
    private String nom;

    @Column(name="Numéro")
    private String numero;

    @Column(name="Date_publication")
    private Date publication;

    @Column(name="fk_ME")
    private Long fkEdition;

}
