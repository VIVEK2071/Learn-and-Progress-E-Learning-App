package com.capg.learningapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.learningapp.dao.StudentDAO;
import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDAO studentdao;

	@Override
	public Student addStudent(Student studentObj) {
		return studentdao.addStudent(studentObj);
	}

	@Override
	public Student updatePhoneNumber(String studentId, String phoneNumber) throws InvalidEntityException {
		return studentdao.updatePhoneNumber(studentId, phoneNumber);
	}

	@Override
	public List<Student> viewAll() {
		return studentdao.viewAll();
	}

	@Override
	public Student viewStudentByID(String studentId) throws InvalidEntityException {
		return studentdao.viewStudentByID(studentId);
	}

	

	

}