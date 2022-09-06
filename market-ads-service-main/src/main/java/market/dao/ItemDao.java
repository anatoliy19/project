package market.dao;

import market.model.Item;

import java.util.List;

public interface ItemDao {
    public void save(Item item);
    public Long saveAndGetId(Item item);
    public void update(Item item);
    public void delete(Long id);
    public Item findById(Long id);
    public List<Item> getAll();
}
