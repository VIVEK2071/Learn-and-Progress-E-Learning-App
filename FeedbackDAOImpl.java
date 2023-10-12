package com.capg.learningapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Enrollment;
import com.capg.learningapp.model.Feedback;
import com.capg.learningapp.repository.EnrollmentRepository;
import com.capg.learningapp.repository.FeedbackRepository;

import java.util.List;

@Service
public class FeedbackDAOImpl implements FeedbackDAO {

    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    EnrollmentRepository enrollmentRepository;

    @Override
    public Feedback addFeedback(Feedback feedbackObj, String enrollmentId) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new InvalidEntityException("Enrollment not found for enrollmentId: " + enrollmentId));
        feedbackObj.setEnrollmentObj(enrollment);
        Feedback feedback = feedbackRepository.saveAndFlush(feedbackObj);
        return feedback;
    }

    @Override
    public Feedback updateFeedbackRating(String enrollmentId, double rating) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new InvalidEntityException("Enrollment not found for enrollmentId: " + enrollmentId));
        Feedback feedback = feedbackRepository.findByEnrollmentObj(enrollment);

        if (feedback == null) {
            throw new InvalidEntityException("Feedback not found for enrollmentId: " + enrollmentId);
        }

        feedback.setRating(rating);
        return feedbackRepository.saveAndFlush(feedback);
    }

    @Override
    public Feedback deleteFeedback(String feedbackId) {
        Feedback feedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new InvalidEntityException("Feedback not found for feedbackId: " + feedbackId));
        feedbackRepository.deleteById(feedbackId);
        return feedback;
    }

    @Override
    public List<Feedback> viewAll() {
        return feedbackRepository.findAll();
    }
}
