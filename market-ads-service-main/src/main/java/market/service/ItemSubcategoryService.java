package market.service;

import market.model.ItemSubcategory;
import market.model.enums.GenderType;
import market.model.enums.ItemCategoryName;

import java.util.List;

public interface ItemSubcategoryService {
    void save(ItemSubcategory subcategory);
    void update(ItemSubcategory subcategory);
    void delete(Long id);
    ItemSubcategory findById(Long id);
    ItemSubcategory findByGenderTypeAndItemCategory(GenderType genderType, ItemCategoryName itemCategoryName);
    List<ItemSubcategory> getAll();
}
