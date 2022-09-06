package market.dao.Impl;

import liquibase.pro.packaged.S;
import market.dao.AdvertisementDao;
import market.model.Advertisement;
import market.model.Item;
import market.model.enums.ApprovedStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

@Repository
public class AdvertisementDaoImpl implements AdvertisementDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Advertisement> getAll() {
        return entityManager.createQuery("""
            select adv
            from Advertisement adv
            """, Advertisement.class).getResultList();
    }

    @Override
    public Advertisement getById(long id) {
        return entityManager.find(Advertisement.class, id);
    }

    @Override
    public void add(Advertisement advertisement) {
        Long idAdvertisement = Long.parseLong(entityManager
                .createNativeQuery("select nextval('advertisements_id_seq')")
                .getSingleResult().toString());
        entityManager.createNativeQuery("""
        insert into advertisement(id, description, create_date, created_by, is_archived, item_id, is_approved)
        values(?, ?, ?, ?, ?, ?, ?)
        """)
                .setParameter(1, idAdvertisement)
                .setParameter(2, advertisement.getDescription())
                .setParameter(3, advertisement.getCreateDate())
                .setParameter(4, advertisement.getCreatedBy())
                .setParameter(5, advertisement.getArchived())
                .setParameter(6, advertisement.getItem().getId())
                .setParameter(7, advertisement.getIsApproved().getNameApprovedStatus())
                .executeUpdate();

        entityManager.createNativeQuery("""
        insert into advertisement_likes(advertisement_id, likes)
        values(?, ?)
        """)
                .setParameter(1, idAdvertisement)
                .setParameter(2, 0L)
                .executeUpdate();
        String query = "insert into advertisement_pictures(advertisement_id, pictures) values(?, ?)";
        for(Long picture : advertisement.getPictures()){
            entityManager.createNativeQuery(query)
                    .setParameter(1, idAdvertisement)
                    .setParameter(2, picture)
                    .executeUpdate();
        }
    }

    @Override
    public void update(Advertisement advertisement) {
        entityManager.createNativeQuery("""
        update advertisement
        set
        created_by=?,
        description=?,
        is_archived=?,
        item_id=?,
        is_approved=?
        where
        id=?
        """)
                .setParameter(1, advertisement.getCreatedBy())
                .setParameter(2, advertisement.getDescription())
                .setParameter(3, advertisement.getArchived())
                .setParameter(4, advertisement.getItem().getId())
                .setParameter(5, advertisement.getIsApproved().getNameApprovedStatus())
                .setParameter(6, advertisement.getId()).executeUpdate();
    }

    @Override
    public void deleteById(long id) {
        entityManager.createNativeQuery("""
        delete from advertisement_likes
        where advertisement_id=?
        """)
                .setParameter(1, id).executeUpdate();

        entityManager.createNativeQuery("""
        delete from advertisement_pictures
        where advertisement_id=?
        """)
                .setParameter(1, id).executeUpdate();
        entityManager.createNativeQuery("""
        delete from advertisement
        where id=?
        """)
                .setParameter(1, id).executeUpdate();
        entityManager.createNativeQuery("""
        delete from item
        where id=?
        """)
                .setParameter(1, id).executeUpdate();
    }

    @Override
    public void archive(long id) {

    }
}
