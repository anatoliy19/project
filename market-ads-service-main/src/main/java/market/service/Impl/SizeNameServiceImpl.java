package market.service.Impl;

import market.dao.SizeNameDao;
import market.model.SizeName;
import market.service.SizeNameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SizeNameServiceImpl implements SizeNameServices {

    private final SizeNameDao sizeNameDao;

    @Autowired
    public SizeNameServiceImpl(SizeNameDao sizeNameDao) {
        this.sizeNameDao = sizeNameDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SizeName> findAll() {return sizeNameDao.findAll();}

    @Override
    @Transactional(readOnly = true)
    public SizeName findById(long id) {return sizeNameDao.showSizeName(id);}

    @Override
    @Transactional
    public void save(SizeName size) {sizeNameDao.save(size);}

    @Override
    @Transactional
    public void update(long id, String name) {sizeNameDao.update(id,name);}

    @Override
    @Transactional
    public void delete(long id) {sizeNameDao.delete(id);}

    @Override
    @Transactional(readOnly = true)
    public SizeName getSizeName(String name){return sizeNameDao.getSizeName(name);}

    @Override
    @Transactional(readOnly = true)
    public boolean checkSizeName(String name){return sizeNameDao.checkSizeName(name);}
}
