package com.raphaellem.api.service;

import com.raphaellem.api.model.Thematique;
import com.raphaellem.api.repository.ThematiqueRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class ThematiqueService {

    @Autowired
    private ThematiqueRepository thematiqueRepository;

    public Optional<Thematique> getThematique(final Long id){
        return thematiqueRepository.findById(id);
    }

    public Iterable<Thematique> getThematiques(){
        return thematiqueRepository.findAll();
    }

    public void deleteThematique(final Long id){
        thematiqueRepository.deleteById(id);
    }

    public Thematique updateThematique(Thematique thematique){
        Thematique updatedThematique = thematiqueRepository.save(thematique);
        return  updatedThematique;
    }

    public Thematique createThematique(Thematique thematique){
        Thematique createdThematique = thematiqueRepository.save(thematique);
        return  createdThematique;
    }

}
