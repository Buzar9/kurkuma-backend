package pl.zhr.scouting.service;

import pl.zhr.scouting.entity.User;

public interface UserService {

    void addUser(User tempUser);

    void updateUser(int userId, User tempUser);
}

