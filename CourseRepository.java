package com.capg.learningapp.repository;

 

import java.time.LocalDate;
import java.util.List;

 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capg.learningapp.model.Course;

 

public interface CourseRepository extends JpaRepository<Course, String>{
	public List<Course> findByCategoryAndDuration(String category, double duration);

}