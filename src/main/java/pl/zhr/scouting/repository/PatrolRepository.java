package pl.zhr.scouting.repository;

import pl.zhr.scouting.entity.Patrol;

import java.util.List;

public interface PatrolRepository {

    List<Patrol> findAll();

    Patrol findById(int patrolId);

    void saveOrUpdate(Patrol tempPatrol);

    void addUser(int patrolId, int userId);

    void delete(int patrolId);
}

