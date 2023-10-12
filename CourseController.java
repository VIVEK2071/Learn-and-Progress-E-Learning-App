package com.capg.learningapp.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Course;
import com.capg.learningapp.service.CourseService;

//In this course controller class we are taking web request from postmant / Angular and calling the respective methods
@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	CourseService courseService;

	@PostMapping("/addCourse")//this method is used for adding the course in the table
	public ResponseEntity<Course> addCourse(@Valid @RequestBody Course course) {//@valid is used triger validation in course entity 
		Course courseObj = courseService.addCourse(course);

		ResponseEntity<Course> rs = new ResponseEntity<Course>(courseObj, HttpStatus.OK);
		return rs;

	}

	@PutMapping("/updateDuration/{courseId}/{duration}")//This updateDuration method is used to update duration based on course id
	public ResponseEntity<Course> updateDuration(@PathVariable(name="courseId") String courseId,@PathVariable(name="duration") double duration)
			throws InvalidEntityException {
		Course courseObj = courseService.updateDuration(courseId, duration);
		ResponseEntity<Course> rs = new ResponseEntity<Course>(courseObj, HttpStatus.OK);
		return rs;
	}

	@GetMapping("/viewAll")//this methods is used to find all the records 
	public ResponseEntity<List<Course>> viewAll() {
		List<Course> list = courseService.viewAll();
		ResponseEntity<List<Course>> rs = new ResponseEntity<List<Course>>(list, HttpStatus.OK);
		return rs;
	}

	@GetMapping("/viewCourseByID/{courseId}")
	public ResponseEntity<Course> viewCourseByID(@PathVariable String courseId) throws InvalidEntityException {
		Course courseObj = courseService.viewCourseByID(courseId);
		ResponseEntity<Course> rs = new ResponseEntity<Course>(courseObj, HttpStatus.OK);
		return rs;
	}

	@GetMapping("/viewCourseByCategoryAndDuration/{category}/{duration}")
	public ResponseEntity<List<Course>> viewCourseByCategoryAndDuration(@PathVariable(name="category") String category,@PathVariable(name="duration") double duration)
			throws InvalidEntityException {
		List<Course> courseObj = courseService.viewCourseByCategoryAndDuration(category,duration);
		ResponseEntity<List<Course>> rs = new ResponseEntity<List<Course>>(courseObj, HttpStatus.OK);
		return rs;
	}

	

}