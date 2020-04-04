package pl.zhr.scouting.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.zhr.scouting.entity.Achievement;
import pl.zhr.scouting.entity.Quest;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class QuestRepositoryImpl implements QuestRepository{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Quest> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("from Quest", Quest.class);
        List<Quest> questList = query.getResultList();

        return questList;
    }

    @Override
    public Quest findById(int questId) {

        Session currentSession = entityManager.unwrap(Session.class);
        Quest tempQuest = currentSession.get(Quest.class, questId);

        return tempQuest;
    }

    @Override
    public void save(Quest tempQuest, int achievementId) {

        Session currentSession = entityManager.unwrap(Session.class);
        Achievement tempAchievement = currentSession.get(Achievement.class, achievementId);
        currentSession.saveOrUpdate(tempQuest);
        tempAchievement.addQuest(tempQuest);
        tempQuest.setAchievementId(tempAchievement);
        tempQuest.setTitle(tempAchievement);
        currentSession.saveOrUpdate(tempAchievement);
    }

    @Override
    public void update(Quest tempQuest) {

        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(tempQuest);
    }

    @Override
    public void delete(int questId) {

        Session currentSession = entityManager.unwrap(Session.class);
        Quest tempQuest = currentSession.get(Quest.class, questId);
        currentSession.delete(tempQuest);
    }
}
