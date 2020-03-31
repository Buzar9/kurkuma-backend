package pl.zhr.scouting.service;

import pl.zhr.scouting.entity.UserData;

public interface UserDataService {

    void updateDataInUser(int userId, UserData userData);
}

