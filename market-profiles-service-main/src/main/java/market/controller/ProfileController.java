package market.controller;


import market.model.Profile;
import market.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// TODO @Константин
// общий маппинг /api/profiles
// сделать ДТО и не принимать целую сущность
// респонсы везде
// ПАГИНАЦИЯ ДЛЯ ПРОФИЛЕЙ ТУТ

@RestController
@RequestMapping()
public class ProfileController {
    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
      }

    @GetMapping("/api/profiles")
    public Profile findProfile(@RequestParam String email) {
        return profileService.findProfileByEmail(email);
    }

    @PostMapping("/api/profiles")
    public Profile saveProfile(@RequestBody Profile profile) {
        return profileService.saveProfile(profile);

    }

    @GetMapping("/api/profile")
    public Profile findProfileById(@RequestParam Long accountId) {
        return profileService.findProfileById(accountId);
    }
}
