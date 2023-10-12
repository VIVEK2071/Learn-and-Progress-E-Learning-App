package com.capg.learningapp.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Enrollment {
    @Id
    @NotBlank(message = "enrollmentId is required")
    @Size(max = 50, message = "enrollmentId must be less than or equal to 50 characters")
    private String enrollmentId;

    @NotNull(message ="startDate is required")
    private LocalDate startDate;

    @NotNull(message ="endDate is required")
    private LocalDate endDate;

    
    private int score;

    @NotBlank(message = "status is required")
    @Size(max = 50, message = "status must be less than or equal to 50 characters")
    private String status;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student studentObj;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainerObj;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course courseObj;

	public String getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Student getStudentObj() {
		return studentObj;
	}

	public void setStudentObj(Student studentObj) {
		this.studentObj = studentObj;
	}

	public Trainer getTrainerObj() {
		return trainerObj;
	}

	public void setTrainerObj(Trainer trainerObj) {
		this.trainerObj = trainerObj;
	}

	public Course getCourseObj() {
		return courseObj;
	}

	public void setCourseObj(Course courseObj) {
		this.courseObj = courseObj;
	}
    
}
