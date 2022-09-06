package market.service.Impl;

import market.dao.AdvertisementDao;
import market.model.Advertisement;
import market.service.AdvertisementService;
import market.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdvertisementServiceImpl implements AdvertisementService {

    private AdvertisementDao advertisementDao;
    private ItemService itemService;

    @Autowired
    public AdvertisementServiceImpl(AdvertisementDao advertisementDao, ItemService itemService) {
        this.advertisementDao = advertisementDao;
        this.itemService = itemService;
    }

    @Override
    public List<Advertisement> getAll() {
        return advertisementDao.getAll();
    }

    @Override
    public Advertisement getById(long id) {
        return advertisementDao.getById(id);
    }

    @Override
    public void add(Advertisement advertisement) {
        Long id = itemService.saveAndGetId(advertisement.getItem());
        advertisement.getItem().setId(id);
        advertisementDao.add(advertisement);
    }

    @Override
    public void update(Advertisement advertisement) {
        itemService.update(advertisement.getItem());
        advertisementDao.update(advertisement);
    }

    @Override
    public void deleteById(long id) {
        advertisementDao.deleteById(id);
    }

    @Override
    public void archive(long id) {
        advertisementDao.archive(id);
    }
}
