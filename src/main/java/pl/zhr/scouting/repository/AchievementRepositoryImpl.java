package pl.zhr.scouting.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.zhr.scouting.entity.Achievement;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AchievementRepositoryImpl implements AchievementRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Achievement> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("from Achievement", Achievement.class);
        List<Achievement> achievementList = query.getResultList();

        return achievementList;
    }

    @Override
    @Transactional
    public Achievement findById(int achivementId) {
        return null;
    }

    @Override
    @Transactional
    public void saveOrUpdate(Achievement tempAchievement) {

    }

    @Override
    @Transactional
    public void delete(int achivmentId) {

    }
}
