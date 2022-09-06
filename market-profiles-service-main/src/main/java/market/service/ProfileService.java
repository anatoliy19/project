package market.service;

import market.model.Profile;

public interface ProfileService {
    Profile findProfileByEmail(String email);

    Profile saveProfile(Profile profile);

    Profile updateProfile(Profile profile);

    Profile findProfileById(Long id);
}
