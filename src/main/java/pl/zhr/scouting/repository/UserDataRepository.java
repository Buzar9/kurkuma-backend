package pl.zhr.scouting.repository;

import pl.zhr.scouting.entity.User;
import pl.zhr.scouting.entity.UserData;

import java.util.List;

public interface UserDataRepository {

    List<UserData> findAll();

    UserData findByUserId(int userId);

    void saveOrUpdate(UserData userData, int userId);

    void deleteUserData(int userId);
}

