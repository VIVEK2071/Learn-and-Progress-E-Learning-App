package com.capg.learningapp.model;

 

import java.time.LocalDate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
public class Student 
{
	@Id
	//@GeneratedValue()
	@NotNull(message = "studentId is required")
    private String studentId;
	
	@NotBlank(message = "studentname is required")
	@Size(max = 50, message = "studentname must be less than or equal to 50 characters") 
    private String studentname;
    
	@NotBlank(message = "city is required")
	@Size(max = 50, message = "city must be less than or equal to 50 characters") 
    private String city;
	
	@NotBlank(message = "phoneNumber is required")
	@Size(max = 50, message = "phoneNumber must be less than or equal to 50 characters") 
    private String phoneNumber;
	
	@Email(message = "emailId is required")
    private String emailId;
	
	@NotNull(message= "dob is required")
    private LocalDate dob;
    
    @OneToMany(mappedBy="studentObj",cascade=CascadeType.ALL)
    @JsonBackReference
    private List<Enrollment> enrollmentList;//j 
    
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public List<Enrollment> getEnrollmentList() {
		return enrollmentList;
	}
	public void setEnrollmentList(List<Enrollment> enrollmentList) {
		this.enrollmentList = enrollmentList;
	}

}