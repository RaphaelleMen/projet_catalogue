package com.raphaellem.api.controller;

import com.raphaellem.api.model.Edition;
import com.raphaellem.api.service.EditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
/*@CrossOrigin("URL CLIENT LOURD")*/
public class EditionController {

    @Autowired
    private EditionService editionService;

    @GetMapping("/editions")
    public Iterable<Edition> getEditions(){
        return editionService.getEditions();
    }

    @GetMapping("/edition/{id}")
    public Optional<Edition> getEdition(@PathVariable Long id){
        return editionService.getEdition(id);
    }

    @DeleteMapping("/edition/{id}")
    public void deleteEdition(@PathVariable Long id){
        editionService.deleteEdition(id);
    }

    @PutMapping("/edition")
    public Edition updateEdition(@RequestBody Edition edition){
        return editionService.updateEdition(edition);
    }

    @PostMapping("/edition")
    public Edition createEdition(@RequestBody Edition edition){
        return editionService.createEdition(edition);
    }
}
