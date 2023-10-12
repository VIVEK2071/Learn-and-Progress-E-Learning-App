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
public class Feedback {
    @Id
    @NotBlank(message = "feedbackId is required")
    @Size(max = 50, message = "feedbackId must be less than or equal to 50 characters")
    private String feedbackId;

    @NotNull(message = "feedbackDate is required")
    private LocalDate feedbackDate;

    @NotBlank(message = "comments is required")
    @Size(max = 500, message = "comments must be less than or equal to 500 characters")
    private String comments;

    
    private double rating;

    @ManyToOne
    @JoinColumn(name = "enrollment_id")
    private Enrollment enrollmentObj;

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    public LocalDate getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(LocalDate feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Enrollment getEnrollmentObj() {
        return enrollmentObj;
    }

    public void setEnrollmentObj(Enrollment enrollmentObj) {
        this.enrollmentObj = enrollmentObj;
    }
}
 