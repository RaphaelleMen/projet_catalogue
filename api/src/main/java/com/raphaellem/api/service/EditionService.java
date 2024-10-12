package com.raphaellem.api.service;

import com.raphaellem.api.model.Edition;
import com.raphaellem.api.repository.EditionRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class EditionService {

    @Autowired
    private EditionRepository editionRepository;

    public Optional<Edition> getEdition(final Long id){
        return editionRepository.findById(id);
    }

    public Iterable<Edition> getEditions(){
        return editionRepository.findAll();
    }

    public void deleteEdition(final Long id){
        editionRepository.deleteById(id);
    }

    public Edition updateEdition(Edition edition){
        Edition updatedEdition = editionRepository.save(edition);
        return  updatedEdition;
    }

    public Edition createEdition(Edition edition){
        Edition createdEdition = editionRepository.save(edition);
        return  createdEdition;
    }

}
