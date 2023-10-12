package com.capg.learningapp.test;import com.capg.learningapp.dao.FeedbackDAO;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.learningapp.exception.InvalidEntityException;
import com.capg.learningapp.model.Feedback;
import com.capg.learningapp.service.FeedbackServiceImpl;

@SpringBootTest
public class FeedbackServiceImplTest {

    @InjectMocks
    FeedbackServiceImpl feedbackService;

    @Mock
    FeedbackDAO feedbackDAO;

    @Test
    void testAddFeedback() throws InvalidEntityException {
        Feedback feedback = new Feedback();
        String enrollmentId = "EN123";

        when(feedbackDAO.addFeedback(feedback, enrollmentId)).thenReturn(feedback);

        Feedback result = feedbackService.addFeedback(feedback, enrollmentId);

        assertNotNull(result);
        assertEquals(feedback, result);
    }

    @Test
    void testUpdateFeedbackRating() throws InvalidEntityException {
        String feedbackId = "FB123";
        double rating = 4.5;
        Feedback updatedFeedback = new Feedback();

        when(feedbackDAO.updateFeedbackRating(feedbackId, rating)).thenReturn(updatedFeedback);

        Feedback result = feedbackService.updateFeedbackRating(feedbackId, rating);

        assertNotNull(result);
        assertEquals(updatedFeedback, result);
    }

    @Test
    void testDeleteFeedback() throws InvalidEntityException {
        String feedbackId = "FB123";
        Feedback deletedFeedback = new Feedback();

        when(feedbackDAO.deleteFeedback(feedbackId)).thenReturn(deletedFeedback);

        Feedback result = feedbackService.deleteFeedback(feedbackId);

        assertNotNull(result);
        assertEquals(deletedFeedback, result);
    }

    @Test
    void testViewAll() {
        List<Feedback> feedbacks = new ArrayList<>();
        when(feedbackDAO.viewAll()).thenReturn(feedbacks);

        List<Feedback> result = feedbackService.viewAll();

        assertNotNull(result);
        assertEquals(feedbacks, result);
    }

    
}
