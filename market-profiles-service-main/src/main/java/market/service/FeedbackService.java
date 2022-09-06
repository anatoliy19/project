package market.service;

import market.model.Feedback;

public interface FeedbackService {
    void deleteFeedbackByID(Long id);
    void updateFeedback(Feedback feedback);
}
