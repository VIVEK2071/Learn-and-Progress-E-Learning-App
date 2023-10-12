package com.capg.learningapp.repository;

 

import java.util.List;

 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

 

import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Trainer;

 

public interface TrainerRepository extends JpaRepository<Trainer ,String>{
	public Trainer findByTrainerId(String trainerId) throws InvalidEntityException;

}