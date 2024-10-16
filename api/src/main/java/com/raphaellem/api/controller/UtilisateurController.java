package com.raphaellem.api.controller;

import com.raphaellem.api.model.Utilisateur;
import com.raphaellem.api.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:9300/")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/utilisateurs")
    public Iterable<Utilisateur> getUtilisateurs(){
        return utilisateurService.getUtilisateurs();
    }

    @GetMapping("/utilisateur/{id}")
    public Optional<Utilisateur> getUtilisateur(@PathVariable Long id){
        return utilisateurService.getUtilisateur(id);
    }

    @DeleteMapping("/utilisateur/{id}")
    public void deleteUtilisateur(@PathVariable Long id){
        utilisateurService.deleteUtilisateur(id);
    }

    @PutMapping("/utilisateur")
    public Utilisateur updateUtilisateur(@RequestBody Utilisateur utilisateur){
        return utilisateurService.updateUtilisateur(utilisateur);
    }

    @PostMapping("/utilisateur")
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur){
        return utilisateurService.createUtilisateur(utilisateur);
    }
}
