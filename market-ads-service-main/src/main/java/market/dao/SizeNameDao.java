package market.dao;


import market.model.SizeName;

import java.util.List;

public interface SizeNameDao {
    public List<SizeName> findAll();

    public SizeName showSizeName(long id);

    public void save(SizeName size);

    public void update(long id, String name);

    public void delete(long id);

    public SizeName getSizeName(String name);
    public boolean checkSizeName(String name);
}
