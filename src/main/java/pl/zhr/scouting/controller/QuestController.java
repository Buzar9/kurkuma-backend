package pl.zhr.scouting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.zhr.scouting.entity.Quest;
import pl.zhr.scouting.repository.QuestRepository;

import java.util.List;

@RestController
@RequestMapping("/quests")
@CrossOrigin(origins = "*")
public class QuestController {

    @Autowired
    private QuestRepository questRepositoryImpl;

    @GetMapping
    public List<Quest> questList(){

        return questRepositoryImpl.findAll();
    }

    @GetMapping("{questId}")
    public Quest findById(@PathVariable int questId) {

        return questRepositoryImpl.findById(questId);
    }

    @PostMapping("/achievement/{achievementId}")
    public void saveQuest(@PathVariable int achievementId,
                          @RequestBody Quest tempQuest){

        tempQuest.setQuestId(0);
        questRepositoryImpl.saveOrUpdate(tempQuest, achievementId);
    }

    @PutMapping("{questId}/achievement/{achievementId}")
    public void updateQuest(@PathVariable int questId,
                            @PathVariable int achievementId,
                            @RequestBody Quest tempQuest) {

        tempQuest.setQuestId(questId);
        questRepositoryImpl.saveOrUpdate(tempQuest, achievementId);
    }

    @DeleteMapping("{questId}")
    public void deleteQuest(@PathVariable int questId) {

        questRepositoryImpl.delete(questId);
    }
}
