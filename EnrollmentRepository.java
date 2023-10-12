package com.capg.learningapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.learningapp.model.Enrollment;

@Repository//This is part of dao and jpaRepository is extended here and entity and Id dataType is passed as generics
public interface EnrollmentRepository extends JpaRepository<Enrollment ,String>{
	
	@Query("SELECT e FROM Enrollment e WHERE e.score = (SELECT MAX(e2.score) FROM Enrollment e2)")
	public List<Enrollment> findByMaxScore();
	
	 @Query("SELECT e FROM Enrollment e ORDER BY e.score")
	public List<Enrollment> findScoreBySort();
	 
	 @Query("SELECT e FROM Enrollment e WHERE e.score = (SELECT MIN(e2.score) FROM Enrollment e2)")
		public List<Enrollment> findByMinScore();
	 
	 

}
