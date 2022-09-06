package market.service;

import market.dao.FeedbackDao;
import market.model.Feedback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FeedbackServiceImpl implements FeedbackService{

    private final FeedbackDao feedbackDao;

    public FeedbackServiceImpl(FeedbackDao feedbackDao) {
        this.feedbackDao = feedbackDao;
    }

    @Override
    @Transactional
    public void deleteFeedbackByID(Long id) {
        feedbackDao.deleteFeedbackById(id);
    }

    @Override
    @Transactional
    public void updateFeedback(Feedback feedback) {
        feedbackDao.updateFeedback(feedback);
    }
}