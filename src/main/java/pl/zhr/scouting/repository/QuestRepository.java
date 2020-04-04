package pl.zhr.scouting.repository;

import pl.zhr.scouting.entity.Quest;

import java.util.List;

public interface QuestRepository {

    List<Quest> findAll();

    Quest findById(int questId);

    void saveOrUpdate(Quest tempQuest,int achievementId);

    void delete(int questId);
}
