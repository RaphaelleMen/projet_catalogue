package com.raphaellem.api.controller;

import com.raphaellem.api.model.Thematique;
import com.raphaellem.api.service.ThematiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
/*@CrossOrigin("URL CLIENT LOURD")*/
public class ThematiqueController {

    @Autowired
    private ThematiqueService thematiqueService;

    @GetMapping("/thematiques")
    public Iterable<Thematique> getThematiques(){
        return thematiqueService.getThematiques();
    }

    @GetMapping("/thematique/{id}")
    public Optional<Thematique> getThematique(@PathVariable Long id){
        return thematiqueService.getThematique(id);
    }

    @DeleteMapping("/thematique/{id}")
    public void deleteThematique(@PathVariable Long id){
        thematiqueService.deleteThematique(id);
    }

    @PutMapping("/thematique")
    public Thematique updateThematique(@RequestBody Thematique thematique){
        return thematiqueService.updateThematique(thematique);
    }

    @PostMapping("/thematique")
    public Thematique createThematique(@RequestBody Thematique thematique){
        return thematiqueService.createThematique(thematique);
    }
}
