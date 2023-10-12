package com.capg.learningapp.repository;

import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.learningapp.model.Enrollment;
import com.capg.learningapp.model.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, String> {

	
	Feedback findByEnrollmentObj(Enrollment enrollment);


}