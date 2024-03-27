package com.sport.running.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.sport.athlete.entity.AthleteEntity;
import com.sport.athlete.repository.AthleteRepository;
import com.sport.athlete.service.AthleteServiceImpl;
import com.sport.running.entity.RunningEntity;
import com.sport.running.repository.RunningRepository;

public class RunningServiceImplTest {

    @Mock
    private RunningRepository runningRepository;
    
    private RunningRepository runningRepositoryMock;

    @InjectMocks
    private RunningServiceImpl runningService;

    @BeforeEach
    public void setUp() {
        runningRepositoryMock = mock(RunningRepository.class);
        runningService = new RunningServiceImpl(runningRepositoryMock);
    }

    @Test
    public void testSaveRunning() {
        RunningEntity running = new RunningEntity();
        Date date = new Date();

        running.setDate(date);
        when(runningRepositoryMock.save(running)).thenReturn(running);

        RunningEntity savedRunning = runningService.saveRunning(running);
        String str = new SimpleDateFormat("dd-MM-yyyy").format(date);
        assertEquals(str, new SimpleDateFormat("dd-MM-yyyy").format(savedRunning.getDate()));
        
    }

    @Test
    public void testUpdateRunning() {
    	
    	RunningEntity existingRunning = new RunningEntity();
    	Date date = new Date();
    	existingRunning.setDate(date);

        when(runningRepositoryMock.save(existingRunning)).thenReturn(existingRunning);

        RunningEntity updatedAthlete = runningService.updateRunning(existingRunning);
        String str = new SimpleDateFormat("dd-MM-yyyy").format(date);
        assertEquals(str, new SimpleDateFormat("dd-MM-yyyy").format(updatedAthlete.getDate()));
        
    }

    @Test
    public void testDeleteRunning() {
        Long idToDelete = 1L;
        ResponseEntity<String> response = runningService.deleteRunning(idToDelete);

        verify(runningRepositoryMock, times(1)).deleteById(idToDelete);
        assertEquals("Running deleted successfully!.", response.getBody());
    }

    @Test
    public void testFindAllRunning() {

        List<RunningEntity> runningList = new ArrayList<>();
        runningList.add(new RunningEntity());
        runningList.add(new RunningEntity());

        when(runningRepositoryMock.findAll()).thenReturn(runningList);

        List<RunningEntity> foundRunning = runningService.findAllRunning();

        assertEquals(2, foundRunning.size());
    }

    @Test
    public void testFindById() {
                
        RunningEntity running = new RunningEntity();
        running.setId(1L);

        when(runningRepositoryMock.findById(1L)).thenReturn(Optional.of(running));

        RunningEntity foundRunning = runningService.findById(1L);

        assertEquals(1L, foundRunning.getId());
    }

    @Test
    public void testFindById_NotFound() {
        
        when(runningRepositoryMock.findById(2L)).thenReturn(Optional.empty());

        RunningEntity foundRunning = runningService.findById(2L);

        assertEquals(null, foundRunning);
    }
}