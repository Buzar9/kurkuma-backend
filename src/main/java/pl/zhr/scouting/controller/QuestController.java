package pl.zhr.scouting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zhr.scouting.entity.Quest;
import pl.zhr.scouting.repository.QuestRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class QuestController {

    @Autowired
    private QuestRepository questRepositoryImpl;

    @GetMapping("/")
    public List<Quest> questList(){

        return questRepositoryImpl.findAll();
    }
}
