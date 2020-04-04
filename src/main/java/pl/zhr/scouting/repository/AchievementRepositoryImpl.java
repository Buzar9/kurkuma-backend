package pl.zhr.scouting.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import pl.zhr.scouting.entity.Achievement;
import pl.zhr.scouting.entity.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class AchievementRepositoryImpl implements AchievementRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Achievement> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("from Achievement", Achievement.class);
        List<Achievement> achievementList = query.getResultList();

        return achievementList;
    }

    @Override
    public Achievement findById(int achievementId) {

        Session currentSession = entityManager.unwrap(Session.class);
        Achievement tempAchievement = currentSession.get(Achievement.class, achievementId);

        return tempAchievement;
    }


    @Override
    public void saveOrUpdate(Achievement tempAchievement) {

        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(tempAchievement);
    }

    @Override
    public void addAchievementToUser(int achievementId, int userId) {

        Session currentSession = entityManager.unwrap(Session.class);
        User tempUser = currentSession.get(User.class, userId);
        Achievement tempAchievement = currentSession.get(Achievement.class, achievementId);
        tempUser.addAchievement(tempAchievement);
        currentSession.saveOrUpdate(tempUser);
        currentSession.saveOrUpdate(tempAchievement);
    }

    @Override
    public void removeAchievementFromUser(int achievementId, int userId) {

        Session currentSession = entityManager.unwrap(Session.class);
        User tempUser = currentSession.get(User.class, userId);
        Achievement tempAchievement = currentSession.get(Achievement.class, achievementId);
        tempUser.removeAchievement(tempAchievement);
        currentSession.saveOrUpdate(tempUser);
        currentSession.saveOrUpdate(tempAchievement);
    }

    @Override
    public void delete(int achievementId) {

        Session currentSession = entityManager.unwrap(Session.class);
        Achievement tempAchievement = currentSession.get(Achievement.class, achievementId);
        currentSession.delete(tempAchievement);
    }
}
