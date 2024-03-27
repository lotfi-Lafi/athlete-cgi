package com.sport.athlete.service;

import com.sport.athlete.entity.AthleteEntity;
import com.sport.athlete.repository.AthleteRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AthleteService {
    AthleteEntity saveAthlete(AthleteEntity athlete);

    AthleteEntity updateAthlete(AthleteEntity athlete);

    ResponseEntity<String> deleteAthlete(Long id);

    List<AthleteEntity> findAllAthletes();

    AthleteEntity findById(Long id);


}
