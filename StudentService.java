package com.capg.learningapp.service;

import java.util.List;

import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Student;

public interface StudentService {
	public Student addStudent(Student studentObj);
	public Student updatePhoneNumber(String studentId, String phoneNumber) throws InvalidEntityException;
	public List<Student> viewAll();
	public Student viewStudentByID(String studentId) throws InvalidEntityException;
	
	
}
