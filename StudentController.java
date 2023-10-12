package com.capg.learningapp.controller;

 

import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

 

import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Student;
import com.capg.learningapp.service.StudentService;

 

@RestController
@RequestMapping("/student")
public class StudentController 
{
	@Autowired
	StudentService studentService;
	@PostMapping("/addStudent")
	public ResponseEntity<Student>addStudent( @RequestBody @Valid Student student) throws InvalidEntityException
	{
		Student studentObj=studentService.addStudent(student);
		ResponseEntity<Student> rs=new ResponseEntity<Student>(studentObj,HttpStatus.OK);
		return rs;
	}

	@PutMapping("/updatePhoneNumber/{studentId}/{phoneNumber}")
	public ResponseEntity<Student>updatePhoneNumber(@PathVariable(name="studentId") String studentId,@PathVariable(name="phoneNumber") String phoneNumber)throws InvalidEntityException
	{
		Student studentObj=studentService.updatePhoneNumber(studentId,phoneNumber);
		ResponseEntity<Student> rs=new ResponseEntity<Student>(studentObj,HttpStatus.OK);
		return rs;
	}

	@GetMapping("/viewAll")
	public ResponseEntity<List<Student>> viewAll()
	{
		List<Student>list=studentService.viewAll();
		ResponseEntity<List<Student>> rs=new ResponseEntity<List<Student>>(list,HttpStatus.OK);
		return rs;
	}
	@GetMapping("/viewStudentByID/{studentId}")
	public ResponseEntity<Student> viewStudentById(@PathVariable String studentId)throws InvalidEntityException
		{
		Student studentObj=studentService.viewStudentByID(studentId);
		ResponseEntity<Student> rs=new ResponseEntity<Student>(studentObj,HttpStatus.OK);
		return rs;
		}

 
 

}