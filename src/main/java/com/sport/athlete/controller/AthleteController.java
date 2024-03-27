package com.sport.athlete.controller;

import com.sport.athlete.entity.AthleteEntity;
import java.util.List;

import com.sport.athlete.service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/v1/athletes"})
public class AthleteController {


    private AthleteService service;

    @Autowired
    public AthleteController(AthleteService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public AthleteEntity save(@RequestBody AthleteEntity athlete) {
        return service.saveAthlete(athlete);
    }

    @GetMapping({"/{id}"})
    public AthleteEntity findByd(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<AthleteEntity> findAllAthletes() {
        return service.findAllAthletes();
    }

    @PutMapping
    public AthleteEntity updateAthlete(@RequestBody AthleteEntity athlete) {
        return service.updateAthlete(athlete);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
    	return service.deleteAthlete(id);
    }
}
