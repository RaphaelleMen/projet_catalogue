package com.raphaellem.api.service;

import com.raphaellem.api.model.Magazine;
import com.raphaellem.api.repository.MagazineRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class MagazineService {

    @Autowired
    private MagazineRepository magazineRepository;

    public Optional<Magazine> getMagazine(final Long id){
        return magazineRepository.findById(id);
    }

    public Iterable<Magazine> getMagazines(){
        return magazineRepository.findAll();
    }

    public void deleteMagazine(final Long id){
        magazineRepository.deleteById(id);
    }

    public Magazine updateMagazine(Magazine magazine){
        Magazine updatedMagazine = magazineRepository.save(magazine);
        return  updatedMagazine;
    }

    public Magazine createMagazine(Magazine magazine){
        Magazine createdMagazine = magazineRepository.save(magazine);
        return  createdMagazine;
    }

}
