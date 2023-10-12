package com.capg.learningapp.service;

import java.util.List;

import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Trainer;

public interface TrainerService {
	public Trainer addTrainer(Trainer trainerObj, String courseId);
	public Trainer updateCourse(String trainerId, String courseId) throws InvalidEntityException;
	public List<Trainer> viewAll();
	public Trainer viewTrainerByID(String TrainerId) throws InvalidEntityException;
	

}
