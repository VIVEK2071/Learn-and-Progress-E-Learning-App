package com.capg.learningapp.model;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

 



 

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {
	@Id
	//@GeneratedValue//(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "Course Id is required")
	@Size(max = 50, message = "Course Id must be less than or equal to 50 characters")
	private String courseId;
	
	 @NotBlank(message = "courseName is required")
		@Size(max = 50, message = "courseName must be less than or equal to 50 characters")
    private String courseName;
	 
	 
    private double duration;
	 
	 @NotBlank(message = "category is required")
		@Size(max = 50, message = "category must be less than or equal to 50 characters") 
    private String category;
    
   @OneToMany(mappedBy="courseObj",cascade=CascadeType.ALL)
    private List<Trainer> trainerList;
    
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<Trainer> getTrainerList() {
		return trainerList;
	}
	public void setTrainerList(List<Trainer> trainerList) {
		this.trainerList = trainerList;
	}
}