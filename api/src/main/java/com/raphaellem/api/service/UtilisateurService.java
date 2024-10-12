package com.raphaellem.api.service;

import com.raphaellem.api.model.Utilisateur;
import com.raphaellem.api.repository.UtilisateurRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Optional<Utilisateur> getUtilisateur(final Long id){
        return utilisateurRepository.findById(id);
    }

    public Iterable<Utilisateur> getUtilisateurs(){
        return utilisateurRepository.findAll();
    }

    public void deleteUtilisateur(final Long id){
        utilisateurRepository.deleteById(id);
    }

    public Utilisateur updateUtilisateur(Utilisateur utilisateur){
        Utilisateur updatedUtilisateur = utilisateurRepository.save(utilisateur);
        return  updatedUtilisateur;
    }

    public Utilisateur createUtilisateur(Utilisateur utilisateur){
        Utilisateur createdUtilisateur = utilisateurRepository.save(utilisateur);
        return  createdUtilisateur;
    }

}
