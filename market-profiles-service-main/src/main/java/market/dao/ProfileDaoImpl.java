package market.dao;

import market.model.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class ProfileDaoImpl implements ProfileDao {
    @PersistenceContext
    private EntityManager em;


    @Override
    public Profile findProfileByEmail(String email) {
        String query = """
                SELECT p
                FROM Profile p
                WHERE p.email = :email
                """;
        try {
            return em.createQuery(query, Profile.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException ignored) {
            return null;
        }
    }

    @Override
    public Profile saveProfile(Profile profile) {
        em.persist(profile);
        return profile;
    }

    @Override
    public Profile updateProfile(Profile profile) {
        em.merge(profile);
        return profile;
    }

    @Override
    public Profile findProfileById(Long id) {
        String query = """
                SELECT p
                FROM Profile p
                WHERE p.accountId = :account_id
                """;
        try {
            return em.createQuery(query, Profile.class)
                    .setParameter("account_id", id)
                    .getSingleResult();
        } catch (NoResultException ignored) {
            return null;
        }
    }
}
