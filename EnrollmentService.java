package com.capg.learningapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Enrollment;

//EnrollmentService provides abstract methods which must be implemented in EnrollmentServiceImpl
public interface EnrollmentService {

	
	public Enrollment addEnrollment(Enrollment enrollmentObj, String studentId, String trainerId, String courseId) throws InvalidEntityException;
	public Enrollment updateScore(String enrollmentId, int score) throws InvalidEntityException;
	public List<Enrollment> viewAll();
	public Enrollment viewEnrollmentByID(String enrollmentId) throws InvalidEntityException;
	public List<Enrollment> viewMaxScore();
	public List<Enrollment> viewScoreBySort();
	public List<Enrollment> viewMinScore();
	
}
