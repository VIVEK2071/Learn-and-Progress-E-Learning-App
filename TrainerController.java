package com.capg.learningapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Trainer;
import com.capg.learningapp.service.TrainerService;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

	@Autowired//used to inject object automatically in spring
	TrainerService trainerService;

	@PostMapping("/addTrainer/{courseId}")//use to add trainer in table 
	public ResponseEntity<Trainer> addTrainer(@Valid @RequestBody Trainer trainer, @PathVariable String courseId)
			throws InvalidEntityException {
		Trainer trainerObj = trainerService.addTrainer(trainer, courseId);
		ResponseEntity<Trainer> rs = new ResponseEntity<Trainer>(trainerObj, HttpStatus.OK);
		return rs;
	}

	@PutMapping("/updateCourse/{trainerId}/{courseId}")//use to update course id by using trainer id
	public ResponseEntity<Trainer> updateCourse(@PathVariable(name = "trainerId") String trainerId,
			@PathVariable(name = "courseId") String courseId) throws InvalidEntityException {
		Trainer trainerObj = trainerService.updateCourse(trainerId, courseId);
		ResponseEntity<Trainer> rs = new ResponseEntity<Trainer>(trainerObj, HttpStatus.OK);
		return rs;
	}

	@GetMapping("/viewAll")
	public ResponseEntity<List<Trainer>> viewAll() {
		List<Trainer> list = trainerService.viewAll();
		ResponseEntity<List<Trainer>> rs = new ResponseEntity<List<Trainer>>(list, HttpStatus.OK);
		return rs;
	}

	@GetMapping("/viewTrainerByID/{trainerId}")
	public ResponseEntity<Trainer> viewTrainerByID(@PathVariable String trainerId) throws InvalidEntityException {
		Trainer trainerObj = trainerService.viewTrainerByID(trainerId);
		ResponseEntity<Trainer> rs = new ResponseEntity<Trainer>(trainerObj, HttpStatus.OK);
		return rs;
	}

}