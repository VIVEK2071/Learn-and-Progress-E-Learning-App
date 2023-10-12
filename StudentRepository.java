package com.capg.learningapp.repository;

 

import java.util.List;

 

 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

 

import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Student;

 


public interface StudentRepository extends JpaRepository<Student,String>
{
	

}