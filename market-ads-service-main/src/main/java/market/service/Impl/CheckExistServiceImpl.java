package market.service.Impl;

import market.dao.ExistDao;
import market.service.CheckExistService;
import org.springframework.stereotype.Service;

@Service
public class CheckExistServiceImpl implements CheckExistService {

    private final ExistDao existDao;

    public CheckExistServiceImpl(ExistDao existDao) {
        this.existDao = existDao;
    }

    @Override
    public Boolean checkExistsEntity(Class entity, Long id) {
        return existDao.checkExistsEntity(entity, id);
    }
}
