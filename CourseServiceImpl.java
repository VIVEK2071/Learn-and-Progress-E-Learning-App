package com.capg.learningapp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.learningapp.dao.CourseDAO;
//import com.capg.learningapp.dao.EnrollmentDAO;
import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Course;
//import com.capg.learningapp.model.Enrollment;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDAO courseDAO;

	@Override
	public Course addCourse(Course courseObj)  {

		return courseDAO.addCourse(courseObj);
	}

	@Override
	public Course updateDuration(String courseId, double duration) throws InvalidEntityException {
		return courseDAO.updateDuration(courseId, duration);
	}

	@Override
	public List<Course> viewAll() {
		return courseDAO.viewAll();
	}

	@Override
	public Course viewCourseByID(String courseId) throws InvalidEntityException {
		return courseDAO.viewCourseByID(courseId);
	}

	@Override
	public List<Course> viewCourseByCategoryAndDuration(String category, double duration) {
		// TODO Auto-generated method stub
		return courseDAO.viewCourseByCategoryAndDuration(category, duration);
	}

	
	

}