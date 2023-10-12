package com.capg.learningapp.service;

 

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

 

//import org.springframework.stereotype.Service;

 

import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Feedback;

 

@Service
public interface FeedbackService {

	public Feedback addFeedback(Feedback feedbackObj, String enrollmentId) throws InvalidEntityException;
	public Feedback updateFeedbackRating(String enrollmentId, double rating) throws InvalidEntityException;
	public Feedback deleteFeedback(String feedbackId) throws InvalidEntityException;
	public List<Feedback> viewAll();
	
}