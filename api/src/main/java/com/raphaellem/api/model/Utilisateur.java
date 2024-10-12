package com.raphaellem.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "utilisateurs")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="identifiant")
    private String identifiant;

    @Column(name="motDePasse")
    private String mdp;

    @Column(name="admin")
    private Boolean admin;

}
