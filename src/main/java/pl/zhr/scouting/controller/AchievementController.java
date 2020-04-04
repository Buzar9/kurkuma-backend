package pl.zhr.scouting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.zhr.scouting.entity.Achievement;
import pl.zhr.scouting.repository.AchievementRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AchievementController {

    @Autowired
    private AchievementRepository achievementRepositoryImpl;

    @GetMapping("/achievements")
    public List<Achievement> getAllAchievements() {

        return achievementRepositoryImpl.findAll();
    }

    @GetMapping("/achievements{achievementId}")
    public Achievement getSingleAchievement(@PathVariable int achievementId) {

        return achievementRepositoryImpl.findById(achievementId);
    }

    @PostMapping("/achievements")
    public void saveAchievement(@RequestBody Achievement tempAchievement) {

        tempAchievement.setAchievementId(0);
        achievementRepositoryImpl.saveOrUpdate(tempAchievement);
    }

    @PutMapping("/achievements{achievementId}")
    public void updateAchievements(@PathVariable int achievementId,
                                    @RequestBody Achievement tempAchievement) {

        tempAchievement.setAchievementId(achievementId);
        achievementRepositoryImpl.saveOrUpdate(tempAchievement);
    }

    @PutMapping("/achievements{achievementId}/user{userId}")
    public void addAchievementToUser(@PathVariable int achievementId,
                                     @PathVariable int userId){
        achievementRepositoryImpl.addAchievementToUser(achievementId, userId);
    }

    @DeleteMapping("/achievements{achievementId}")
    public void deleteAchievement(@PathVariable int achievementId) {

        achievementRepositoryImpl.delete(achievementId);
    }
}
