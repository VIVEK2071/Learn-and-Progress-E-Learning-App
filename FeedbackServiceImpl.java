package com.capg.learningapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.learningapp.dao.FeedbackDAO;
import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Feedback;

@Service//this is service feedback
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	FeedbackDAO feedbackDao;

	public Feedback addFeedback(Feedback feedbackObj, String enrollmentId) throws InvalidEntityException{
		
		return feedbackDao.addFeedback(feedbackObj, enrollmentId);
	}

	public Feedback updateFeedbackRating(String enrollmentId, double rating) throws InvalidEntityException{
		return feedbackDao.updateFeedbackRating(enrollmentId,rating);
	}
	public Feedback deleteFeedback(String feedbackId) throws InvalidEntityException {
		return feedbackDao.deleteFeedback(feedbackId);
	}

	public List<Feedback> viewAll() {
		return feedbackDao.viewAll();
	}

	
	

}