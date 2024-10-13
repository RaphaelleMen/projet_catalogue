package com.raphaellem.api.controller;

import com.raphaellem.api.model.AllMagazines;
import com.raphaellem.api.service.AllMagazinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:9300/")
public class AllMagazinesController {

    @Autowired
    private AllMagazinesService allMagazinesService;

    @GetMapping("/allMagazines")
    public List<AllMagazines> getAllMagazines(@RequestParam(required = false) String nomMagazine, @RequestParam(required = false) Long fkThematique, @RequestParam(required = false)Date dateMagazine) {
        return allMagazinesService.getAllMagazines(nomMagazine, fkThematique, dateMagazine);
    }
}