package pl.zhr.scouting.repository;

import pl.zhr.scouting.entity.Realization;

import java.util.List;

public interface RealizationRepository {

    List<Realization> findAll();

    Realization findById(int realizationId);

    void saveOrUpdate(Realization tempRealization, int userId, int questId);

    void addRelationQuestReal(int realId, int questId);

    void setRealizationData(int realId);

    void delete(int realizationId);

    void removeRelationQuestReal(int realId);
}
