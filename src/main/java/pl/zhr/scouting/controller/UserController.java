package pl.zhr.scouting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.zhr.scouting.entity.User;
import pl.zhr.scouting.repository.UserRepository;
import pl.zhr.scouting.service.UserService;


import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    @Autowired
    private UserRepository userRepositoryImpl;

    @GetMapping("/users")
    public List<User> findAll() {

        return userRepositoryImpl.findAll();
    }

    @GetMapping("/users/{userId}")
    public User findUserById (@PathVariable(value = "userId") int userId) {

        User tempUser = userRepositoryImpl.findByUserId(userId);

        return tempUser;
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User tempUser) {

        userServiceImpl.addUser(tempUser);
    }

    @PutMapping("/users/{userId}")
    public void updateUser(@PathVariable int userId,
                           @RequestBody User tempUser) {

        userServiceImpl.updateUser(userId, tempUser);
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable(value = "userId") int userId) {

        userRepositoryImpl.deleteUser(userId);

        return "Deleted user id - " + userId;
    }
}

