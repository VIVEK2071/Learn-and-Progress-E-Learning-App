package com.capg.learningapp.dao;

 

import java.util.ArrayList;

import java.util.List;

import java.util.Optional;

 

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

 

import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Course;
import com.capg.learningapp.model.Trainer;
import com.capg.learningapp.repository.CourseRepository;
import com.capg.learningapp.repository.TrainerRepository;

 

@Service

public class TrainerDAOImpl implements TrainerDAO{

 

	@Autowired
	TrainerRepository trainerRepository;
	
	@Autowired
	CourseRepository courseRepository;

	

	@Override

	public Trainer addTrainer(Trainer trainerObj, String courseId) {
	    try {
	        Course course = courseRepository.findById(courseId).orElse(null);

	 

	        if (course == null) {
	            throw new InvalidEntityException("Course with ID " + courseId + " does not exist.");
	        }

	 

	        trainerObj.setCourseObj(course);

	 

	        Trainer trainer = trainerRepository.saveAndFlush(trainerObj);

	 

	        return trainer;
	    } catch (Exception ex) {
	        throw new InvalidEntityException("Failed to add trainer", ex);
	    }
	}

 

	@Override

//	public Trainer updateCourse(String trainerId, String courseId) throws InvalidEntityException {
//        try {
//            Optional<Trainer> opTrainer = trainerRepository.findById(trainerId);
//            Trainer trainerObj = opTrainer.orElseThrow(() -> new InvalidEntityException("Trainer not found for ID: " + trainerId));
//
// 
//
//            trainerObj.getCourseObj().setCourseId(courseId);
//            Trainer trainer = trainerRepository.saveAndFlush(trainerObj);
//            return trainer;
//        } catch (Exception ex) {
//            throw new InvalidEntityException("Failed to update trainer course", ex);
//        }
//    }
	public Trainer updateCourse(String trainerId, String courseId) throws InvalidEntityException {
	    try {
	        Optional<Trainer> opTrainer = trainerRepository.findById(trainerId);
	        
	        if (opTrainer.isPresent()) {
	            Trainer trainerObj = opTrainer.get();
	            Course course = courseRepository.findById(courseId)
	                .orElseThrow(() -> new InvalidEntityException("Course not found for ID: " + courseId));
	            
	            // Assuming you want to update the trainer's course to the new course
	            trainerObj.setCourseObj(course);
	            
	            Trainer trainer = trainerRepository.saveAndFlush(trainerObj);
	            return trainer;
	        } else {
	            throw new InvalidEntityException("Trainer not found for ID: " + trainerId);
	        }
	    } catch (Exception ex) {
	        throw new InvalidEntityException("Failed to update trainer course", ex);
	    }
	}


 

	@Override

	public List<Trainer> viewAll() {
        try {
            List<Trainer> list = trainerRepository.findAll();
            return list;
        } catch (Exception ex) {
            throw new InvalidEntityException("Failed to retrieve trainers", ex);
        }
    }

 

	@Override

	public Trainer viewTrainerByID(String trainerId) throws InvalidEntityException {
        try {
            Trainer trainer = trainerRepository.findByTrainerId(trainerId);
            if (trainer == null) {
                throw new InvalidEntityException("Trainer not found for ID: " + trainerId);
            }
            return trainer;
        } catch (Exception ex) {
            throw new InvalidEntityException("Failed to retrieve trainer", ex);
        }
    }

 

	
 

}