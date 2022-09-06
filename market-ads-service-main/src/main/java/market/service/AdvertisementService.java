package market.service;

import market.model.Advertisement;

import java.util.List;

public interface AdvertisementService {
    List<Advertisement> getAll();
    Advertisement getById(long id);
    void add(Advertisement advertisement);
    void update(Advertisement updatedAdvertisement);
    void deleteById(long id);
    void archive(long id);
}
