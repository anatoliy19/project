package market.dao.Impl;

import market.dao.SizeNameDao;
import market.model.SizeName;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SizeNameDaoImpl implements SizeNameDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<SizeName> findAll() {
        return entityManager.createQuery("FROM SizeName", SizeName.class)
            .getResultList();
    }

    @Override
    public SizeName showSizeName(long id)  {return entityManager.find(SizeName.class, id);}

    @Override
    public void save(SizeName size) {
        entityManager.merge(size);
    }

    @Override
    public void update(long id, String name) {
        SizeName n = entityManager.find(SizeName.class, id);
        n.setName(name);
        entityManager.merge(n);
    }

    @Override
    public void delete(long id) {entityManager.remove(showSizeName(id));}

    @Override
    public SizeName getSizeName(String name){
        return entityManager.find(SizeName.class,name);
    }

    @Override
    public boolean checkSizeName(String name){
        return entityManager.find(SizeName.class, name)!=null;
    }
}
