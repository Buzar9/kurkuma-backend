package pl.zhr.scouting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zhr.scouting.entity.Achievement;
import pl.zhr.scouting.repository.AchievementRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AchievementController {

    @Autowired
    private AchievementRepository achievementRepositoryImpl;

    @GetMapping("/achievements")
    public List<Achievement> achievements() {

        return achievementRepositoryImpl.findAll();
    }
}
