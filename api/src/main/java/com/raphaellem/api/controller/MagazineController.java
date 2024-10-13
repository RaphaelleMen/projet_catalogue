package com.raphaellem.api.controller;

import com.raphaellem.api.model.Magazine;
import com.raphaellem.api.service.MagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:9300/")
public class MagazineController {

    @Autowired
    private MagazineService magazineService;

    @GetMapping("/magazines")
    public Iterable<Magazine> getMagazines(){
        return magazineService.getMagazines();
    }

    @GetMapping("/magazine/{id}")
    public Optional<Magazine> getMagazine(@PathVariable Long id){
        return magazineService.getMagazine(id);
    }

    @DeleteMapping("/magazine/{id}")
    public void deleteMagazine(@PathVariable Long id){
        magazineService.deleteMagazine(id);
    }

    @PutMapping("/magazine")
    public Magazine updateMagazine(@RequestBody Magazine magazine){
        return magazineService.updateMagazine(magazine);
    }

    @PostMapping("/magazine")
    public Magazine createMagazine(@RequestBody Magazine magazine){
        return magazineService.createMagazine(magazine);
    }
    @GetMapping("/magazineByNom")
    public Iterable<Magazine> getMagazineNom(@RequestParam(required = false) String nom) {
        if (nom != null && !nom.isEmpty()) {
            return magazineService.getMagazineNom(nom);
        } else {
            return magazineService.getMagazines();
        }

    }
}
