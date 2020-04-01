package pl.zhr.scouting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.zhr.scouting.entity.User;
import pl.zhr.scouting.repository.UserRepository;
import pl.zhr.scouting.service.UserService;


import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    @Autowired
    private UserRepository userRepositoryImpl;

    @GetMapping
    public List<User> findAll() {

        return userRepositoryImpl.findAll();
    }

    @GetMapping("/{userId}")
    public User findUserById (@PathVariable(value = "userId") int userId) {

        User tempUser = userRepositoryImpl.findByUserId(userId);

        return tempUser;
    }

    @PostMapping
    public void addUser(@RequestBody User tempUser) {

        userServiceImpl.addUser(tempUser);
    }

    @PutMapping("/{userId}")
    public void updateUser(@PathVariable int userId,
                           @RequestBody User tempUser) {

        userServiceImpl.updateUser(userId, tempUser);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable(value = "userId") int userId) {

        userRepositoryImpl.deleteUser(userId);

        return "Deleted user id - " + userId;
    }
}

