package com.capg.learningapp.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.learningapp.dao.StudentDAO;
import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Student;
import com.capg.learningapp.service.StudentServiceImpl;

@SpringBootTest
public class StudentServiceImplTest {

    @InjectMocks
    StudentServiceImpl studentService;

    @Mock
    StudentDAO studentDAO;

    @Test
    void testAddStudent() {
        Student student = new Student();

        when(studentDAO.addStudent(student)).thenReturn(student);

        Student result = studentService.addStudent(student);

        assertNotNull(result);
        assertEquals(student, result);
    }

    @Test
    void testUpdatePhoneNumber() throws InvalidEntityException {
        String studentId = "S123";
        String phoneNumber = "1234567890";
        Student updatedStudent = new Student();

        when(studentDAO.updatePhoneNumber(studentId, phoneNumber)).thenReturn(updatedStudent);

        Student result = studentService.updatePhoneNumber(studentId, phoneNumber);

        assertNotNull(result);
        assertEquals(updatedStudent, result);
    }

    @Test
    void testViewAll() {
        List<Student> students = new ArrayList<>();
        when(studentDAO.viewAll()).thenReturn(students);

        List<Student> result = studentService.viewAll();

        assertNotNull(result);
        assertEquals(students, result);
    }

    @Test
    void testViewStudentByID() throws InvalidEntityException {
        String studentId = "S123";
        Student student = new Student();

        when(studentDAO.viewStudentByID(studentId)).thenReturn(student);

        Student result = studentService.viewStudentByID(studentId);

        assertNotNull(result);
        assertEquals(student, result);
    }

    
}
