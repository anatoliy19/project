package market.service;

import market.model.SizeName;

import java.util.List;

public interface SizeNameServices {
    List<SizeName> findAll();
    SizeName findById(long id);
    void save(SizeName size);
    void update(long id, String name);
    void delete(long id);
    SizeName getSizeName(String name);
    boolean checkSizeName(String name);
}
