package com.capg.learningapp.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.learningapp.dao.CourseDAO;
import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Course;
import com.capg.learningapp.service.CourseServiceImpl;

@SpringBootTest
public class CourseServiceImplTest {

    @InjectMocks
    CourseServiceImpl courseService;

    @Mock
    CourseDAO courseDAO;

    @Test
    void testAddCourse() {
        Course course = new Course();
        when(courseDAO.addCourse(course)).thenReturn(course);

        Course result = courseService.addCourse(course);

        assertNotNull(result);
        assertEquals(course, result);
    }

    @Test
    void testUpdateDuration() throws InvalidEntityException {
        String courseId = "123";
        double duration = 10.5;
        Course updatedCourse = new Course();

        when(courseDAO.updateDuration(courseId, duration)).thenReturn(updatedCourse);

        Course result = courseService.updateDuration(courseId, duration);

        assertNotNull(result);
        assertEquals(updatedCourse, result);
    }

    @Test
    void testViewAll() {
        List<Course> courses = new ArrayList<>();
        when(courseDAO.viewAll()).thenReturn(courses);

        List<Course> result = courseService.viewAll();

        assertNotNull(result);
        assertEquals(courses, result);
    }

    @Test
    void testViewCourseByID() throws InvalidEntityException {
        String courseId = "123";
        Course course = new Course();

        when(courseDAO.viewCourseByID(courseId)).thenReturn(course);

        Course result = courseService.viewCourseByID(courseId);

        assertNotNull(result);
        assertEquals(course, result);
    }

    @Test
    void testViewCourseByCategoryAndDuration() {
        String category = "Programming";
        double duration = 20.5;
        List<Course> courses = new ArrayList<>();

        when(courseDAO.viewCourseByCategoryAndDuration(category, duration)).thenReturn(courses);

        List<Course> result = courseService.viewCourseByCategoryAndDuration(category, duration);

        assertNotNull(result);
        assertEquals(courses, result);
    }

    @Test
    void testViewCourseByTrainerId() {
        String trainerId = "T123";
        List<Course> courses = new ArrayList<>();

        when(courseDAO.viewCourseByTrainerId(trainerId)).thenReturn(courses);

        List<Course> result = courseService.viewCourseByTrainerId(trainerId);

        assertNotNull(result);
        assertEquals(courses, result);
    }

    @Test
    void testViewCourseByStartDate() {
        LocalDate startDate = LocalDate.now();
        List<Course> courses = new ArrayList<>();

        when(courseDAO.viewCourseByStartDate(startDate)).thenReturn(courses);

        List<Course> result = courseService.viewCourseByStartDate(startDate);

        assertNotNull(result);
        assertEquals(courses, result);
    }

    @Test
    void testViewCourseWithMaxStudents() {
        List<Course> courses = new ArrayList<>();

        when(courseDAO.viewCourseWithMaxStudents()).thenReturn(courses);

        List<Course> result = courseService.viewCourseWithMaxStudents();

        assertNotNull(result);
        assertEquals(courses, result);
    }
}
