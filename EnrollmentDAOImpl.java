package com.capg.learningapp.dao;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Course;
import com.capg.learningapp.model.Enrollment;
import com.capg.learningapp.model.Student;
import com.capg.learningapp.model.Trainer;
import com.capg.learningapp.repository.CourseRepository;
import com.capg.learningapp.repository.EnrollmentRepository;
import com.capg.learningapp.repository.StudentRepository;
import com.capg.learningapp.repository.TrainerRepository;

@Service
public class EnrollmentDAOImpl implements EnrollmentDAO{

	@Autowired
	EnrollmentRepository enrollmentRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	TrainerRepository trainerRepository;
	@Autowired
	CourseRepository courseRepository;
	
	//Methods of repository of are called in this method like findById ,save etc
	@Override
	public Enrollment addEnrollment(Enrollment enrollmentObj, String studentId, String trainerId, String courseId)
	        throws InvalidEntityException {
	    try {
	        Student student = studentRepository.findById(studentId).orElse(null);
	        Trainer trainer = trainerRepository.findById(trainerId).orElse(null);
	        Course course = courseRepository.findById(courseId).orElse(null);

	 

	        if (student == null || trainer == null || course == null) {
	            throw new InvalidEntityException("Student, Trainer, or Course not found");
	        }

	 

	        enrollmentObj.setStudentObj(student);
	        enrollmentObj.setTrainerObj(trainer);
	        enrollmentObj.setCourseObj(course);

	 

	        Enrollment enrollment = enrollmentRepository.save(enrollmentObj);
	        return enrollment;
	    } catch (Exception ex) {
	        throw new InvalidEntityException("Failed to add enrollment", ex);
	    }
	}

	//data is fetched and updated and again saved into the database
	@Override
	public Enrollment updateScore(String enrollmentId, int score) throws InvalidEntityException {
	    try {
	        Optional<Enrollment> opEnrollment = enrollmentRepository.findById(enrollmentId);
	        Enrollment enrollmentObj = opEnrollment.orElseThrow(() -> new InvalidEntityException("Enrollment not found"));

	 

	        enrollmentObj.setScore(score);
	        Enrollment enrollment = enrollmentRepository.saveAndFlush(enrollmentObj);
	        return enrollment;
	    } catch (Exception ex) {
	        throw new InvalidEntityException("Failed to update enrollment score", ex);
	    }
	}

	//All the records are fetched from table and appropriate exception is thrown 
	@Override
	public List<Enrollment> viewAll() {
	    try {
	        List<Enrollment> list = enrollmentRepository.findAll();
	        return list;
	    } catch (Exception ex) {
	        throw new InvalidEntityException("Failed to view all enrollments", ex);
	    }
	}

	//In this method perticular row/Object is fetched by using id
	@Override
	public Enrollment viewEnrollmentByID(String enrollmentId) throws InvalidEntityException {
	    try {
	        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
	                .orElseThrow(() -> new InvalidEntityException("Enrollment not found"));
	        return enrollment;
	    } catch (Exception ex) {
	        throw new InvalidEntityException("Failed to view enrollment by ID", ex);
	    }
	}

	@Override
	public List<Enrollment> viewMaxScore() {
		
		  try {
			  List<Enrollment> enrollment = enrollmentRepository.findByMaxScore();
		               
		        return enrollment;
		    } catch (Exception ex) {
		        throw new InvalidEntityException("Failed to get max score", ex);
		    }
	}
	@Override
	public List<Enrollment> viewScoreBySort() {
		
		  try {
			  List<Enrollment> enrollment = enrollmentRepository.findScoreBySort();
		               
		        return enrollment;
		    } catch (Exception ex) {
		        throw new InvalidEntityException("Failed to get sort score", ex);
		    }
	}
	
	@Override
	public List<Enrollment> viewMinScore() {
		
		  try {
			  List<Enrollment> enrollment = enrollmentRepository.findByMinScore();
		               
		        return enrollment;
		    } catch (Exception ex) {
		        throw new InvalidEntityException("Failed to get min score", ex);
		    }
	}
	
	
}
