package pl.zhr.scouting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.zhr.scouting.entity.User;
import pl.zhr.scouting.entity.UserData;
import pl.zhr.scouting.repository.UserDataRepository;
import pl.zhr.scouting.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDataRepository userDataRepositoryImpl;

    @Autowired
    private UserRepository userRepositoryImpl;

    @Override
    @Transactional
    public void addUser(User tempUser) {

        tempUser.setUserId(0);
        UserData tempUserData = new UserData(null, null, null);
        userRepositoryImpl.saveOrUpdate(tempUser);
        userDataRepositoryImpl.saveOrUpdate(tempUserData, tempUser.getUserId());
    }

    @Override
    @Transactional
    public void updateUser(int userId, User tempUser) {

        tempUser.setUserId(userId);
        userRepositoryImpl.saveOrUpdate(tempUser);
    }
}

