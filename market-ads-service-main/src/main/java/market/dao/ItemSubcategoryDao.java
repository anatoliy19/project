package market.dao;

import market.model.ItemSubcategory;
import market.model.enums.GenderType;
import market.model.enums.ItemCategoryName;

import java.util.List;

public interface ItemSubcategoryDao {

    public void save(ItemSubcategory subcategory);
    public void update(ItemSubcategory subcategory);
    public void delete(Long id);
    public ItemSubcategory findById(Long id);
    public ItemSubcategory findByGenderTypeAndItemCategory(GenderType genderType, ItemCategoryName itemCategoryName);
    public List<ItemSubcategory> getAll();
}
