package pl.zhr.scouting.repository;

import pl.zhr.scouting.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository{

    List<User> findAll();

    User findByUserId(int userId);

    Optional<User> findByUsername(String username);

    void saveOrUpdate(User user);

    void deleteUser(int userId);
}

