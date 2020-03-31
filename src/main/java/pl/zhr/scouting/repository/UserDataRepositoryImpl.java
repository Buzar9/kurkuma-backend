package pl.zhr.scouting.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.zhr.scouting.entity.User;
import pl.zhr.scouting.entity.UserData;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDataRepositoryImpl implements UserDataRepository{

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<UserData> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);
        Query<UserData> query = currentSession.createQuery("from UserData", UserData.class);
        List<UserData> userDataList = query.getResultList();

        return userDataList;
    }

    @Override
    @Transactional
    public UserData findByUserId(int userId) {

        Session currentSession = entityManager.unwrap(Session.class);
        User tempUser = currentSession.get(User.class, userId);
        UserData tempUserData = tempUser.getUserDataId();

        return tempUserData;
    }

    @Override
    @Transactional
    public void saveOrUpdate(UserData tempUserData, int userId) {

        Session currentSession = entityManager.unwrap(Session.class);
        User tempUser = currentSession.get(User.class, userId);
        currentSession.saveOrUpdate(tempUserData);
        tempUser.addData(tempUserData);
        tempUserData.setUser(tempUser);
        tempUserData.setUsername();
        currentSession.saveOrUpdate(tempUser);
    }

    @Override
    @Transactional
    public void deleteUserData(int userId) {

        Session currentSession = entityManager.unwrap(Session.class);
        User tempUser = currentSession.get(User.class, userId);
        UserData tempUserData = tempUser.getUserDataId();
        currentSession.delete(tempUserData);
        tempUser.setUserDataId(null);
    }
}

