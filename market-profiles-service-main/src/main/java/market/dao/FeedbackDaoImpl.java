package market.dao;

import market.model.Feedback;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class FeedbackDaoImpl implements FeedbackDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void deleteFeedbackById(Long id) {
        Feedback feedback = entityManager.find(Feedback.class,id);
        if(feedback !=null){
            entityManager.remove(feedback);
        }
    }

    @Override
    public void updateFeedback(Feedback feedback) {
        Feedback feedbackForUpdate = entityManager.getReference(Feedback.class,feedback.getId());
        feedbackForUpdate.setDescription(feedback.getDescription());
        feedbackForUpdate.setScore(feedback.getScore());
    }
}