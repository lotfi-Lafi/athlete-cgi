package com.sport.running.controller;

import java.util.List;

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

import com.sport.running.entity.RunningEntity;
import com.sport.running.service.RunningServiceImpl;

@RestController
@RequestMapping({"/api/v1/running"})
public class RunningController {

	 private RunningServiceImpl service;

	    @Autowired
	    public RunningController(RunningServiceImpl service) {
	        this.service = service;
	    }
	    
	    @PostMapping
	    @ResponseStatus(code = HttpStatus.CREATED)
	    public RunningEntity save(@RequestBody RunningEntity running) {
	        return service.saveRunning(running);
	    }

	    @GetMapping({"/{id}"})
	    public RunningEntity findByd(@PathVariable("id") Long id) {
	        return service.findById(id);
	    }

	    @GetMapping
	    public List<RunningEntity> findAllAthletes() {
	        return service.findAllRunning();
	    }

	    @PutMapping
	    public RunningEntity updateAthlete(@RequestBody RunningEntity running) {
	        return service.updateRunning(running);
	    }

	    @DeleteMapping({"/{id}"})
	    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
	    	return service.deleteRunning(id);
	    }
}