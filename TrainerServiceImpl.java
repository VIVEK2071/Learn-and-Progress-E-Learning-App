package com.capg.learningapp.service;

 

import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 

import com.capg.learningapp.dao.TrainerDAO;
import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Trainer;

 

@Service
public class TrainerServiceImpl implements TrainerService{
@Autowired
TrainerDAO trainerDao;

	@Override
	public Trainer addTrainer(Trainer trainerObj, String courseId) {

		return trainerDao.addTrainer(trainerObj,courseId);
	}

 

	@Override
	public Trainer updateCourse(String trainerId, String courseId) throws InvalidEntityException {

		return trainerDao.updateCourse(trainerId, courseId) ;
	}

 

	@Override
	public List<Trainer> viewAll() {

		return trainerDao.viewAll();
	}

 

	@Override
	public Trainer viewTrainerByID(String TrainerId) throws InvalidEntityException {

		return trainerDao.viewTrainerByID(TrainerId);
	}

 

	

 

}