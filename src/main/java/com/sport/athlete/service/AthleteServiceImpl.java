package com.sport.athlete.service;

import com.sport.athlete.entity.AthleteEntity;
import com.sport.athlete.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@Service
public class AthleteServiceImpl implements AthleteService {

    @Autowired
    private AthleteRepository athleteRepository;

    public AthleteServiceImpl(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }
    @Override
    public AthleteEntity saveAthlete(AthleteEntity athlete) {
        return this.athleteRepository.save(athlete);
    }

    @Override
    public AthleteEntity updateAthlete(AthleteEntity athlete) {
    	return athleteRepository.save(athlete);
    }

    @Override
    public ResponseEntity<String> deleteAthlete(Long id) {
        this.athleteRepository.deleteById(id);
        return  ResponseEntity.ok("Athlete deleted successfully!.");
    }

    @Override
    public List<AthleteEntity> findAllAthletes() {
        return this.athleteRepository.findAll();
    }

    @Override
    public AthleteEntity findById(Long id) {
        Optional<AthleteEntity> athlete = this.athleteRepository.findById(id);
        return athlete.orElse(null);
    }
}
