package com.capg.learningapp.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.learningapp.dao.EnrollmentDAO;
import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Enrollment;
import com.capg.learningapp.service.EnrollmentServiceImpl;

@SpringBootTest//This class tests the methods service class
public class EnrollmentServiceImplTest {

    @InjectMocks
    EnrollmentServiceImpl enrollmentService;

    @Mock
    EnrollmentDAO enrollmentDAO;

    @Test
    void testAddEnrollment() throws InvalidEntityException {
        Enrollment enrollment = new Enrollment();
        String studentId = "S123";
        String trainerId = "T123";
        String courseId = "C123";

        when(enrollmentDAO.addEnrollment(enrollment, studentId, trainerId, courseId)).thenReturn(enrollment);

        Enrollment result = enrollmentService.addEnrollment(enrollment, studentId, trainerId, courseId);

        assertNotNull(result);
        assertEquals(enrollment, result);
        
    }

    @Test
    void testUpdateScore() throws InvalidEntityException {
        String enrollmentId = "E123";
        int score = 90;
        Enrollment updatedEnrollment = new Enrollment();

        when(enrollmentDAO.updateScore(enrollmentId, score)).thenReturn(updatedEnrollment);

        Enrollment result = enrollmentService.updateScore(enrollmentId, score);

        assertNotNull(result);
        assertEquals(updatedEnrollment, result);
    }

    @Test
    void testViewAll() {
        List<Enrollment> enrollments = new ArrayList<>();
        when(enrollmentDAO.viewAll()).thenReturn(enrollments);

        List<Enrollment> result = enrollmentService.viewAll();

        assertNotNull(result);
        assertEquals(enrollments, result);
    }

    @Test
    void testViewEnrollmentByID() throws InvalidEntityException {
        String enrollmentId = "E123";
        Enrollment enrollment = new Enrollment();

        when(enrollmentDAO.viewEnrollmentByID(enrollmentId)).thenReturn(enrollment);

        Enrollment result = enrollmentService.viewEnrollmentByID(enrollmentId);

        assertNotNull(result);
        assertEquals(enrollment, result);
    }

    
}
