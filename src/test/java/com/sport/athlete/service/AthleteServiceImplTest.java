package com.sport.athlete.service;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sport.AthleteApplication;
import com.sport.athlete.entity.AthleteEntity;
import com.sport.athlete.repository.AthleteRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

@SpringBootTest(classes = AthleteApplication.class)
public class AthleteServiceImplTest {
	
	@MockBean
	private AthleteRepository athleteRepositoryMock;
   
    @Autowired
    private AthleteService service;

    
    @Test
    public void shoudSaveAthleteSuccessfully() {
        AthleteEntity athleteToSave = new AthleteEntity();
            athleteToSave.setFirstName("Test Athlete");
            athleteToSave.setLastName("for test");
            athleteToSave.setMaxSpeed(20);
            athleteToSave.setAge(22);
            athleteToSave.setHeight(123);
            athleteToSave.setWeight(85);        
        when(athleteRepositoryMock.save(athleteToSave)).thenReturn(athleteToSave);

        AthleteEntity savedAthlete = service.saveAthlete(athleteToSave);

        assertEquals("Test Athlete", savedAthlete.getFirstName());
       
    }
    
    @Test
    public void testUpdateAthlete() {
        AthleteEntity expectedAthlete = new AthleteEntity();
        AthleteEntity givenAthlete = new AthleteEntity(); // N.B
        when(athleteRepositoryMock.save(givenAthlete)).thenReturn(expectedAthlete);

        AthleteEntity updatedAthlete = service.updateAthlete(givenAthlete);

        assertEquals(expectedAthlete, updatedAthlete);
    }
    
    @Test
    public void testDeleteAthlete() {
        Long idToDelete = 1L;

        ResponseEntity<String> response = service.deleteAthlete(idToDelete);

        verify(athleteRepositoryMock, times(1)).deleteById(idToDelete);
        assertEquals("Athlete deleted successfully!.", response.getBody());
    }
    
    @Test
    public void testFindAllAthletes() {
        List<AthleteEntity> athletes = new ArrayList<>();
        athletes.add(new AthleteEntity());
        athletes.add(new AthleteEntity());

        when(athleteRepositoryMock.findAll()).thenReturn(athletes);

        List<AthleteEntity> foundAthletes = service.findAllAthletes();

        assertEquals(2, foundAthletes.size());
    }
    
    
    @Test
    public void testFindById_WhenIdExists() {
        AthleteEntity expectedAthlete = new AthleteEntity();

        when(athleteRepositoryMock.findById(1L)).thenReturn(Optional.of(expectedAthlete));

        AthleteEntity foundAthlete = service.findById(1L);

        assertEquals(expectedAthlete, foundAthlete);
    }
    
    @Test
    public void testFindById_WhenIdDoesNotExist() {
        when(athleteRepositoryMock.findById(2L)).thenReturn(Optional.empty());

        AthleteEntity foundAthlete = service.findById(2L);

        assertEquals(null, foundAthlete);
    }
};