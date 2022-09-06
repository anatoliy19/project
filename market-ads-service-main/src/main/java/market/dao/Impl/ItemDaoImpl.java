package market.dao.Impl;

import market.dao.ItemDao;
import market.model.Item;
import market.model.ItemSubcategory;
import market.model.SizeName;
import market.model.enums.ItemCondition;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ItemDaoImpl implements ItemDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Item item) {
        saveAndGetId(item);
    }
    @Override
    public Long saveAndGetId(Item item){
        Long idItem = Long.parseLong(entityManager
                .createNativeQuery("select nextval('items_id_seq')")
                .getSingleResult().toString());
        entityManager.createNativeQuery("""
            insert into item(id, brand, model, price, item_condition, item_subcategory_id, sizename_id)
            values(?, ?, ?, ?, ?, ?, ?)
        """)
                .setParameter(1, idItem)
                .setParameter(2, item.getBrand())
                .setParameter(3, item.getModel())
                .setParameter(4, item.getPrice())
                .setParameter(5, item.getItemCondition().getNameItemCondition())
                .setParameter(6, item.getItemSubcategory().getId())
                .setParameter(7, item.getSizeName().getId())
                .executeUpdate();
        return idItem;
    }

    @Override
    public void update(Item item) {
        entityManager.createNativeQuery("""
        update item
        set
        brand=?,
        model=?,
        price=?,
        item_condition=?,
        item_subcategory_id=?,
        sizename_id=?
        where
        id=?
        """)
                .setParameter(1, item.getBrand())
                .setParameter(2, item.getModel())
                .setParameter(3, item.getPrice())
                .setParameter(4, item.getItemCondition().getNameItemCondition())
                .setParameter(5, item.getItemSubcategory().getId())
                .setParameter(6, item.getSizeName().getId())
                .setParameter(7, item.getId())
                .executeUpdate();
    }

    @Override
    public void delete(Long id) {
        entityManager.createQuery("""
        delete from Item i where i.id=:id
        """)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public Item findById(Long id) {
        return entityManager.find(Item.class, id);
    }

    @Override
    public List<Item> getAll() {
        return entityManager.createQuery("""
            select item
            from Item item
            """, Item.class).getResultList();
    }
}
