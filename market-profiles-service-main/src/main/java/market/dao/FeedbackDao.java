package market.dao;

import market.model.Feedback;

public interface FeedbackDao {
    void deleteFeedbackById(Long id);
    void updateFeedback(Feedback feedback);
}
