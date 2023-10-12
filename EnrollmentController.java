package com.capg.learningapp.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Enrollment;
import com.capg.learningapp.service.EnrollmentService;
import com.capg.learningapp.service.StudentService;

//In this enrollment controller class we are taking web request from postmant / Angular and calling the respective methods
@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

	@Autowired
	EnrollmentService enrollmentService;

	@PostMapping("/addEnrollment/{studentId}/{trainerId}/{courseId}") // this method is used for adding the enrollment
																		// row in the table
	public ResponseEntity<Enrollment> addEnrollment(@Valid @RequestBody Enrollment enrollment,
			@PathVariable(name = "studentId") String studentId, @PathVariable(name = "trainerId") String trainerId,
			@PathVariable(name = "courseId") String courseId) throws InvalidEntityException {

		Enrollment enrollmentObj = enrollmentService.addEnrollment(enrollment, studentId, trainerId, courseId);
		ResponseEntity<Enrollment> rs = new ResponseEntity<Enrollment>(enrollmentObj, HttpStatus.OK);
		return rs;
	}

	@PutMapping("/updateScoreTime/{enrollmentId}/{score}") // This method is used to update the scores by using
															// enrollmentId
	public ResponseEntity<Enrollment> updateScore(@PathVariable(name = "enrollmentId") String enrollmentId,
			@PathVariable(name = "score") int score) throws InvalidEntityException {
		Enrollment enrollmentObj = enrollmentService.updateScore(enrollmentId, score);
		ResponseEntity<Enrollment> rs = new ResponseEntity<Enrollment>(enrollmentObj, HttpStatus.OK);
		return rs;
	}

	@GetMapping("/viewAll") // This method is called for viewing all the records from Enrollment table
	public ResponseEntity<List<Enrollment>> viewAll() {

		List<Enrollment> list = enrollmentService.viewAll();
		ResponseEntity<List<Enrollment>> rs = new ResponseEntity<List<Enrollment>>(list, HttpStatus.OK);
		return rs;
	}

	@GetMapping("/viewEnrollmentByID/{enrollmentId}") // This method is used to get enrollment by using id
	public ResponseEntity<Enrollment> viewEnrollmentByID(@PathVariable String enrollmentId)
			throws InvalidEntityException {
		Enrollment enrollmentObj = enrollmentService.viewEnrollmentByID(enrollmentId);
		ResponseEntity<Enrollment> rs = new ResponseEntity<Enrollment>(enrollmentObj, HttpStatus.OK);
		return rs;
	}
	@GetMapping("/viewMax")
	public ResponseEntity<List<Enrollment>> viewMaxScore() {

		List<Enrollment> list = enrollmentService.viewMaxScore();
		ResponseEntity<List<Enrollment>> rs = new ResponseEntity<List<Enrollment>>(list, HttpStatus.OK);
		return rs;
	}
	
	@GetMapping("/viewScoreBysort")
	public ResponseEntity<List<Enrollment>> viewScoreBySort() {

		List<Enrollment> list = enrollmentService.viewScoreBySort();
		ResponseEntity<List<Enrollment>> rs = new ResponseEntity<List<Enrollment>>(list, HttpStatus.OK);
		return rs;
	}
	@GetMapping("/viewMin")
	public ResponseEntity<List<Enrollment>> viewMinScore() {

		List<Enrollment> list = enrollmentService.viewMinScore();
		ResponseEntity<List<Enrollment>> rs = new ResponseEntity<List<Enrollment>>(list, HttpStatus.OK);
		return rs;
	}

}
