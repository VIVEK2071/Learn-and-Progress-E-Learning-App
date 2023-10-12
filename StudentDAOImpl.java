package com.capg.learningapp.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Student;
import com.capg.learningapp.repository.StudentRepository;

@Service
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student addStudent(Student studentObj) {
        try {
            Student student = studentRepository.save(studentObj);
            return student;
        } catch (Exception ex) {
            throw new InvalidEntityException("Failed to add student", ex);
        }
    }

	@Override
	public Student updatePhoneNumber(String studentId, String phoneNumber) throws InvalidEntityException {
		try {
		Optional<Student> opStudent = studentRepository.findById(studentId);
        if (!opStudent.isPresent()) {
            throw new InvalidEntityException("Student not found");
        }

 

        Student studentObj = opStudent.get();
        studentObj.setPhoneNumber(phoneNumber);
        Student student = studentRepository.saveAndFlush(studentObj);
        return student;
		} catch (Exception ex) {
            throw new InvalidEntityException("Failed to update student", ex);
        }
    }

	@Override
	public List<Student> viewAll() {
        try {
            List<Student> list = studentRepository.findAll();
            return list;
        } catch (Exception ex) {
            throw new InvalidEntityException("Failed to view all students", ex);
        }
    }

	@Override
	public Student viewStudentByID(String studentId) throws InvalidEntityException {
        Optional<Student> opStudent = studentRepository.findById(studentId);
        if (!opStudent.isPresent()) {
            throw new InvalidEntityException("Student not found");
        }

 

        return opStudent.get();
    }

	

	

}