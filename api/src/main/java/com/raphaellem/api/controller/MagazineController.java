package com.raphaellem.api.controller;

import com.raphaellem.api.model.Magazine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
/*@CrossOrigin("URL CLIENT LOURD")*/
public class MagazineController {

    @Autowired
    private MagazineController magazineController;

    @GetMapping("/magazines")
    public Iterable<Magazine> getMagazine(){
        return magazineController.getMagazine();
    }

    @GetMapping("/magazine/{id}")
    public Optional<Magazine> getMagazine(@PathVariable Long id){
        return magazineController.getMagazine(id);
    }

    @DeleteMapping("/magazine/{id}")
    public void deleteMagazine(@PathVariable Long id){
        magazineController.deleteMagazine(id);
    }

    @PutMapping("/magazine")
    public Magazine updateMagazine(@RequestBody Magazine magazine){
        return magazineController.updateMagazine(magazine);
    }

    @PostMapping("/magazine")
    public Magazine createMagazine(@RequestBody Magazine magazine){
        return magazineController.createMagazine(magazine);
    }
}
