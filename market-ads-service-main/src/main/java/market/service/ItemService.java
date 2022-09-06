package market.service;

import market.model.Item;

import java.util.List;

public interface ItemService {

    void save(Item item);
    Long saveAndGetId(Item item);
    void update(Item item);
    void delete(Long id);
    Item findById(Long id);
    List<Item> getAll();
}
