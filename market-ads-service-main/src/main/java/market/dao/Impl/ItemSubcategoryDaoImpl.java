package market.dao.Impl;

import market.dao.ItemSubcategoryDao;
import market.model.ItemSubcategory;
import market.model.enums.GenderType;
import market.model.enums.ItemCategoryName;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ItemSubcategoryDaoImpl implements ItemSubcategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(ItemSubcategory subcategory) {
        entityManager.persist(subcategory);
        entityManager.flush();
    }

    @Override
    public void update(ItemSubcategory subcategory) {
        entityManager.merge(subcategory);
    }

    @Override
    public void delete(Long id) {
        ItemSubcategory subcategory = entityManager.find(ItemSubcategory.class, id);
        entityManager.remove(subcategory);
    }

    @Override
    public ItemSubcategory findById(Long id) {
        return entityManager.find(ItemSubcategory.class, id);
    }

    @Override
    public ItemSubcategory findByGenderTypeAndItemCategory(GenderType genderType, ItemCategoryName itemCategoryName) {
        return entityManager.createQuery("""
            select subcategory
            from ItemSubcategory subcategory
            where subcategory.genderType =: genderType
            and subcategory.itemCategoryName =: itemCategoryName
            """, ItemSubcategory.class)
                .setParameter("genderType", genderType)
                .setParameter("itemCategoryName", itemCategoryName)
                .getSingleResult();
    }

    @Override
    public List<ItemSubcategory> getAll() {
        return entityManager.createQuery("""
            select subcategory
            from ItemSubcategory subcategory
            """, ItemSubcategory.class).getResultList();
    }
}
