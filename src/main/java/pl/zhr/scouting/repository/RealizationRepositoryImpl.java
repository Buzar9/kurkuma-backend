package pl.zhr.scouting.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.zhr.scouting.entity.Quest;
import pl.zhr.scouting.entity.Realization;
import pl.zhr.scouting.entity.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class RealizationRepositoryImpl implements RealizationRepository{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Realization> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("from Realization", Realization.class);
        List<Realization> realizationList = query.getResultList();

        return realizationList;
    }

    @Override
    public Realization findById(int realizationId) {

        Session currentSession = entityManager.unwrap(Session.class);
        Realization tempRealization = currentSession.get(Realization.class, realizationId);

        return tempRealization;
    }

    @Override
    public void saveOrUpdate(Realization tempRealization, int userId, int questId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Quest tempQuest = currentSession.get(Quest.class, questId);
        User tempUser = currentSession.get(User.class, userId);

        tempRealization.setQuestId(tempQuest);
        tempRealization.setUserId(tempUser);

        currentSession.saveOrUpdate(tempRealization);
    }

    @Override
    public void addRelationQuestReal(int realId, int questId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Quest tempQuest = currentSession.get(Quest.class, questId);
        Realization tempRealization = currentSession.get(Realization.class, realId);

        tempQuest.addRealization(tempRealization);
    }

    @Override
    public void setRealizationData(int realId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Realization tempRealization = currentSession.get(Realization.class, realId);

        tempRealization.setUserId(tempRealization.getUserId());
        tempRealization.setUsername(tempRealization.getUserId());
    }

    @Override
    public void delete(int realizationId) {

        Session currentSession = entityManager.unwrap(Session.class);
        Realization tempRealization = currentSession.get(Realization.class, realizationId);
        currentSession.delete(tempRealization);
    }
}
