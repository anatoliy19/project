package market.service;

import market.controller.ProfileController;
import market.dao.ProfileDao;
import market.model.Profile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfileServiceImpl implements ProfileService {
    private final ProfileDao profileDao;
    private static final Logger LOGGER= LoggerFactory.getLogger(ProfileServiceImpl.class);

    public ProfileServiceImpl(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    @Override
    public Profile findProfileByEmail(String email) {
        LOGGER.info("RequestParam:" + email);
        return profileDao.findProfileByEmail(email);
    }

    @Transactional
    @Override
    public Profile saveProfile(Profile profile) {
        LOGGER.info("Request body: " + profile.toString());
        return profileDao.saveProfile(profile);
    }

    @Transactional
    @Override
    public Profile updateProfile(Profile profile) {
        LOGGER.info("Request body: " + profile.toString());
        return profileDao.updateProfile(profile);
    }

    @Override
    public Profile findProfileById(Long id) {
        return profileDao.findProfileById(id);
    }
}
