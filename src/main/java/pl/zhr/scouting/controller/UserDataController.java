package pl.zhr.scouting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.zhr.scouting.entity.User;
import pl.zhr.scouting.entity.UserData;
import pl.zhr.scouting.repository.UserDataRepository;
import pl.zhr.scouting.repository.UserRepository;
import pl.zhr.scouting.service.UserDataService;

import java.util.List;

@RestController
@RequestMapping("/data")
@CrossOrigin(origins = "*")
public class UserDataController {

    @Autowired
    private UserDataService userDataServiceImpl;

    @Autowired
    private UserDataRepository userDataRepositoryImpl;

    @GetMapping
    public List<UserData> findAll() {

        List<UserData> userDataList = userDataRepositoryImpl.findAll();

        return userDataList;
    }

    @GetMapping("/user{userId}")
    public UserData findUserDataByUserId (@PathVariable int userId) {

        UserData tempUserData = userDataRepositoryImpl.findByUserId(userId);

        return tempUserData;
    }

    @PostMapping("/user{userId}")
    public void addDataToUser(@PathVariable int userId,
                                @RequestBody UserData tempUserData){

        tempUserData.setUserDataId(0);
        userDataRepositoryImpl.saveOrUpdate(tempUserData, userId);
    }

    @PutMapping("/user{userId}")
    public void updateDataInUser(@PathVariable int userId,
                                 @RequestBody UserData tempUserData) {

        userDataServiceImpl.updateDataInUser(userId, tempUserData);
    }

    @DeleteMapping("/user{userId}")
    public String deleteUserData(@PathVariable int userId){

        userDataRepositoryImpl.deleteUserData(userId);

        return "Deleted data user id - " + userId;
    }
}

