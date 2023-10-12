package com.capg.learningapp.service;

 

import java.time.LocalDate;
import java.util.List;

 

import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Course;

 

public interface CourseService {

	public Course addCourse(Course   courseObj);
	public Course updateDuration(String courseId, double duration) throws InvalidEntityException;
	public List<Course> viewAll();
	public Course viewCourseByID(String courseId) throws InvalidEntityException;
	public List<Course>  viewCourseByCategoryAndDuration(String category, double duration);
	
 

}