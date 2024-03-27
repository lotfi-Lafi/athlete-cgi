package com.sport.running.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sport.running.entity.RunningEntity;
import com.sport.running.repository.RunningRepository;

@Service
public class RunningServiceImpl {
	
	@Autowired
    private RunningRepository runningRepository;
	
	public RunningServiceImpl(RunningRepository runningRepository) {
        this.runningRepository = runningRepository;
    }
	
    public RunningEntity saveRunning(RunningEntity running) {
        return this.runningRepository.save(running);
    }
    
    public RunningEntity updateRunning(RunningEntity running) {
        return this.runningRepository.save(running);
    }

    public ResponseEntity<String> deleteRunning(Long id) {
        this.runningRepository.deleteById(id);
        return  ResponseEntity.ok("Running deleted successfully!.");
    }

    public List<RunningEntity> findAllRunning() {
        return this.runningRepository.findAll();
    }

    public RunningEntity findById(Long id) {
        Optional<RunningEntity> running = this.runningRepository.findById(id);
        return running.orElse(null);
    }
}