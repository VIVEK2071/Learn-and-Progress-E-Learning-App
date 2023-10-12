package com.capg.learningapp.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Course;
import com.capg.learningapp.repository.CourseRepository;
import com.capg.learningapp.repository.StudentRepository;

@Service
public class CourseDAOImpl implements CourseDAO {
	@Autowired
	CourseRepository courseRepository;
	 @Autowired
	 StudentRepository studentRepository;

	@Override
	public Course addCourse(Course courseObj) {
        try {
            return courseRepository.save(courseObj);
        } catch (Exception ex) {
            throw new InvalidEntityException("Failed to add course", ex);
        }
    }

	@Override
	public Course updateDuration(String courseId, double duration) throws InvalidEntityException {
        try {
            if (courseId == null || courseId.isEmpty()) {
                throw new InvalidEntityException("Course Id is invalid");
            }

            Optional<Course> optionalCourse = courseRepository.findById(courseId);

            if (optionalCourse.isPresent()) {
                Course course = optionalCourse.get();
                course.setDuration(duration);
                return courseRepository.save(course);
            } else {
                throw new InvalidEntityException("Course with ID " + courseId + " not found");
            }
        } catch (Exception ex) {
            throw new InvalidEntityException("Failed to update course duration", ex);
        }
    }

	@Override
	public List<Course> viewAll() {
	    try {
	        List<Course> courses = courseRepository.findAll();
	        if (courses.isEmpty()) {
	            throw new InvalidEntityException("No courses found");
	        }
	        return courses;
	    } catch (Exception ex) {
	        throw new InvalidEntityException("Failed to retrieve courses", ex);
	    }
	}

	@Override
	public Course viewCourseByID(String courseId) throws InvalidEntityException {
        try {
            Course course = courseRepository.findById(courseId).orElse(null);
            if (course != null) {
                return course;
            } else {
                throw new InvalidEntityException("Course with ID " + courseId + " not found");
            }
        } catch (Exception ex) {
            throw new InvalidEntityException("Failed to retrieve course by ID", ex);
        }
		}

	@Override
	public List<Course> viewCourseByCategoryAndDuration(String category, double duration) {
	    try {
	        List<Course> course = courseRepository.findByCategoryAndDuration(category, duration);
	        if (course.isEmpty()) {
	            throw new InvalidEntityException("No courses found for the given category and duration");
	        }
	        return course;
	    } catch (Exception ex) {
	        throw new InvalidEntityException("Failed to retrieve courses by category and duration", ex);
	    }
	}

	
}