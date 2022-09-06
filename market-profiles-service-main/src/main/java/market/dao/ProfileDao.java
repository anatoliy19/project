package market.dao;

import market.model.Profile;

public interface ProfileDao {
    Profile findProfileByEmail(String email);

    Profile saveProfile(Profile profile);

    Profile updateProfile(Profile profile);

    Profile findProfileById(Long id);
}
