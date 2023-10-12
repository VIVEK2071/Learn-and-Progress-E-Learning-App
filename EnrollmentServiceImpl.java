package com.capg.learningapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.learningapp.dao.EnrollmentDAO;
import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Enrollment;

//In this service class Respective methods of DAO are called .
@Service//This annotation is specilization of @component used specifically for Service classes 
public class EnrollmentServiceImpl implements EnrollmentService {

	@Autowired//this is used to inject object in the given reference
	EnrollmentDAO enrollmentDAO;
	
	 
	@Override
	public Enrollment addEnrollment(Enrollment enrollmentObj, String studentId, String trainerId, String courseId)
			throws InvalidEntityException {
		return enrollmentDAO.addEnrollment(enrollmentObj, studentId, trainerId, courseId);
		 
	}

	@Override
	public Enrollment updateScore(String enrollmentId, int score) throws InvalidEntityException {
		
		return enrollmentDAO.updateScore(enrollmentId, score);
	}

	@Override
	public List<Enrollment> viewAll() {
		
		return enrollmentDAO.viewAll();
	}

	@Override
	public Enrollment viewEnrollmentByID(String enrollmentId) throws InvalidEntityException {
		
		return enrollmentDAO.viewEnrollmentByID(enrollmentId);
	}

	@Override
	public List<Enrollment> viewMaxScore() {
		
		return enrollmentDAO.viewMaxScore();
	}

	@Override
	public List<Enrollment> viewScoreBySort() {
		
		return enrollmentDAO.viewScoreBySort();
	}
	@Override
	public List<Enrollment> viewMinScore() {
		
		return enrollmentDAO.viewMinScore();
	}

	

}
