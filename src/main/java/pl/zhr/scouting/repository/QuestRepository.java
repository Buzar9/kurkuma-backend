package pl.zhr.scouting.repository;

import pl.zhr.scouting.entity.Quest;

import java.util.List;

public interface QuestRepository {

    List<Quest> findAll();

    Quest findById(int questId);

    void save(Quest tempQuest, int achievementId);

    void update(Quest tempQuest);

    void delete(int questId);
}
