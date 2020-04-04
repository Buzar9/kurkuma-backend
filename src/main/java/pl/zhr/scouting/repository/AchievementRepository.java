package pl.zhr.scouting.repository;

import pl.zhr.scouting.entity.Achievement;

import java.util.List;

public interface AchievementRepository {

    List<Achievement> findAll();

    Achievement findById(int achievementId);

    void saveOrUpdate(Achievement tempAchievement);

    void addAchievementToUser(int achievementId, int userId);

    void removeAchievementFromUser(int achievementId, int userId);

    void delete(int achievementId);
}
