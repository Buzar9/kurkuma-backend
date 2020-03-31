package pl.zhr.scouting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.zhr.scouting.entity.User;
import pl.zhr.scouting.entity.UserData;
import pl.zhr.scouting.repository.UserDataRepository;
import pl.zhr.scouting.repository.UserRepository;

@Service
public class UserDataServiceImpl implements UserDataService{

    @Autowired
    private UserRepository userRepositoryImpl;

    @Autowired
    private UserDataRepository userDataRepositoryImpl;

    @Override
    @Transactional
    public void updateDataInUser(int userId, UserData tempUserData) {

        User tempUser = userRepositoryImpl.findByUserId(userId);
        if(tempUser.getUserDataId() != null) {
            userDataRepositoryImpl.deleteUserData(userId);
        }
        userDataRepositoryImpl.saveOrUpdate(tempUserData, userId);

    }
}

