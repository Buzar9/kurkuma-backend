package pl.zhr.scouting.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.zhr.scouting.entity.Quest;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
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
        return null;
    }

    @Override
    public void saveOrUpdate(Quest tempQuest) {

    }

    @Override
    public void delete(int questId) {

    }
}
