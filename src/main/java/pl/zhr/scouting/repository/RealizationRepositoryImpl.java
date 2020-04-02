package pl.zhr.scouting.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.zhr.scouting.entity.Realization;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
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
        return null;
    }

    @Override
    public void saveOrUpdate(Realization tempRealization) {

    }

    @Override
    public void delete(int realizationId) {

    }
}
