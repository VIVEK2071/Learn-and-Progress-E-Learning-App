package com.capg.learningapp.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.learningapp.dao.TrainerDAO;
import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Trainer;
import com.capg.learningapp.service.TrainerServiceImpl;

@SpringBootTest
public class TrainerServiceImplTest {

    @InjectMocks
    TrainerServiceImpl trainerService;

    @Mock
    TrainerDAO trainerDAO;

    @Test
    void testAddTrainer() {
        Trainer trainer = new Trainer();
        String courseId = "C123";

        when(trainerDAO.addTrainer(trainer, courseId)).thenReturn(trainer);

        Trainer result = trainerService.addTrainer(trainer, courseId);

        assertNotNull(result);
        assertEquals(trainer, result);
    }

    @Test
    void testUpdateCourse() throws InvalidEntityException {
        String trainerId = "T123";
        String courseId = "C123";
        Trainer updatedTrainer = new Trainer();

        when(trainerDAO.updateCourse(trainerId, courseId)).thenReturn(updatedTrainer);

        Trainer result = trainerService.updateCourse(trainerId, courseId);

        assertNotNull(result);
        assertEquals(updatedTrainer, result);
    }

    @Test
    void testViewAll() {
        List<Trainer> trainers = new ArrayList<>();

        when(trainerDAO.viewAll()).thenReturn(trainers);

        List<Trainer> result = trainerService.viewAll();

        assertNotNull(result);
        assertEquals(trainers, result);
    }

    @Test
    void testViewTrainerByID() throws InvalidEntityException {
        String trainerId = "T123";
        Trainer trainer = new Trainer();

        when(trainerDAO.viewTrainerByID(trainerId)).thenReturn(trainer);

        Trainer result = trainerService.viewTrainerByID(trainerId);

        assertNotNull(result);
        assertEquals(trainer, result);
    }

    
}

