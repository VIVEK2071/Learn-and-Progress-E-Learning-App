package com.capg.learningapp.dao;

 

import java.util.List;
import java.util.Map;

import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Feedback;

 

public interface FeedbackDAO {

 

	public Feedback addFeedback(Feedback feedbackObj, String enrollmentId) throws InvalidEntityException;
	public Feedback updateFeedbackRating(String enrollmentId, double rating) throws InvalidEntityException;
	public Feedback deleteFeedback(String feedbackId) throws InvalidEntityException;
	public List<Feedback> viewAll();
	
	
}