package com.capg.learningapp.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
public @Data class Trainer {

	@Id
	//@GeneratedValue
	@NotBlank(message = "trainerId is required")
	@Size(max = 50, message = "trainerId must be less than or equal to 50 characters") 
	private String trainerId;

	@NotBlank(message = "trainerName is required")
	@Size(max = 50, message = "trainerName must be less than or equal to 50 characters") 
	private String trainerName;

	@NotBlank(message = "qualification is required")
	@Size(max = 50, message = "qualification must be less than or equal to 50 characters") 
	private String qualification;

	@NotBlank(message = "phoneNumber is required")
	@Size(max = 50, message = "phoneNumber must be less than or equal to 50 characters") 
	private String phoneNumber;

	@NotBlank(message = "address is required")
	@Size(max = 50, message = "address must be less than or equal to 50 characters") 
	private String address;

	@ManyToOne
	@JoinColumn(name="course_id")
	 @JsonBackReference
	Course courseObj;

	public String getTrainerId() {

		return trainerId;

	}

	public void setTrainerId(String trainerId) {

		this.trainerId = trainerId;

	}

	public String getTrainerName() {

		return trainerName;

	}

	public void setTrainerName(String trainerName) {

		this.trainerName = trainerName;

	}

	public String getQualification() {

		return qualification;

	}

	public void setQualification(String qualification) {

		this.qualification = qualification;

	}

	public String getPhoneNumber() {

		return phoneNumber;

	}

	public void setPhoneNumber(String phoneNumber) {

		this.phoneNumber = phoneNumber;

	}

	public String getAddress() {

		return address;

	}

	public void setAddress(String address) {

		this.address = address;

	}

	public Course getCourseObj() {

		return courseObj;

	}

	public void setCourseObj(Course courseObj) {

		this.courseObj = courseObj;

	}

 

	

}