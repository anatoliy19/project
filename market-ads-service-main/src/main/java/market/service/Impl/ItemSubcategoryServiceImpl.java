package market.service.Impl;

import market.dao.ItemSubcategoryDao;
import market.model.ItemSubcategory;
import market.model.enums.GenderType;
import market.model.enums.ItemCategoryName;
import market.service.ItemSubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemSubcategoryServiceImpl implements ItemSubcategoryService {

    @Autowired
    ItemSubcategoryDao itemSubcategoryDao;

    @Override
    public void save(ItemSubcategory subcategory) {
        itemSubcategoryDao.save(subcategory);
    }

    @Override
    public void update(ItemSubcategory subcategory) {
        itemSubcategoryDao.update(subcategory);
    }

    @Override
    public void delete(Long id) {
        itemSubcategoryDao.delete(id);
    }

    @Override
    public ItemSubcategory findById(Long id) {
        return itemSubcategoryDao.findById(id);
    }

    @Override
    public ItemSubcategory findByGenderTypeAndItemCategory(GenderType genderType, ItemCategoryName itemCategoryName) {
        return itemSubcategoryDao.findByGenderTypeAndItemCategory(genderType, itemCategoryName);
    }

    @Override
    public List<ItemSubcategory> getAll() {
        return itemSubcategoryDao.getAll();
    }
}
