package com.capg.learningapp.controller;

 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 

import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Feedback;
import com.capg.learningapp.service.CourseService;
import com.capg.learningapp.service.FeedbackService;

 


 

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	FeedbackService feedbackService;

	@PostMapping("/addFeedback/{enrollmentId}")
	public ResponseEntity<Feedback> addFeedback( @RequestBody @Valid Feedback feedback, @PathVariable String enrollmentId) throws InvalidEntityException
	{
		Feedback feedbackObj=feedbackService.addFeedback(feedback,enrollmentId);
		ResponseEntity<Feedback> fb=new ResponseEntity<Feedback>(feedbackObj,HttpStatus.OK);
		return fb;
	}

	@PutMapping("/updateFeedbackRating/{enrollmentId}/{rating}")
	public ResponseEntity<Feedback> updateFeedbackRating(@PathVariable(name="enrollmentId") String enrollmentId,@PathVariable(name="rating")int rating) throws InvalidEntityException
	{
		Feedback feedbackObj=feedbackService.updateFeedbackRating(enrollmentId, rating);
		ResponseEntity<Feedback> fb =new ResponseEntity<Feedback>(feedbackObj,HttpStatus.OK);
		return fb;
	}
	@DeleteMapping("/deleteFeedback/{feedbackId}")
	public ResponseEntity<Feedback> deleteFeedback(@PathVariable String feedbackId)throws InvalidEntityException {

			Feedback feedbackObj=feedbackService.deleteFeedback(feedbackId);
			ResponseEntity<Feedback> fb =new ResponseEntity<Feedback>(feedbackObj,HttpStatus.OK);
			return fb;
	}

	@GetMapping("/viewAll")
	public ResponseEntity<List<Feedback>> viewAll()
	{
		
		List<Feedback> list=feedbackService.viewAll();
		ResponseEntity<List<Feedback>> fb=new ResponseEntity<List<Feedback>>(list,HttpStatus.OK);
		return fb;
	}

	

	
}

 