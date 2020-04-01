package pl.zhr.scouting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.zhr.scouting.entity.Patrol;
import pl.zhr.scouting.repository.PatrolRepository;

import java.util.List;

@RestController
@RequestMapping("/patrols")
@CrossOrigin(origins = "*")
public class PatrolController {

    @Autowired
    private PatrolRepository patrolRepositoryImpl;

    @GetMapping
    public List<Patrol> findAllPatrols() {

        List<Patrol> patrolList = patrolRepositoryImpl.findAll();

        return patrolList;
    }

    @GetMapping("/{patrolId}")
    public Patrol findPatrolById(@PathVariable(value = "patrolId") int patrolId) {

        Patrol tempPatrol = patrolRepositoryImpl.findById(patrolId);

        return tempPatrol;
    }

    @PostMapping
    public void savePatrol(@RequestBody Patrol tempPatrol) {

        tempPatrol.setPatrolId(0);
        patrolRepositoryImpl.saveOrUpdate(tempPatrol);
    }

    @PutMapping("/{patrolId}")
    public void updatePatrol(@PathVariable int patrolId,
                             @RequestBody Patrol tempPatrol) {

        tempPatrol.setPatrolId(patrolId);
        patrolRepositoryImpl.saveOrUpdate(tempPatrol);
    }

    @PutMapping("/{patrolId}/{userId}")
    public void addUserToPatrol(@PathVariable(value = "patrolId") int patrolId,
                                  @PathVariable(value = "userId") int userId){

       patrolRepositoryImpl.addUser(patrolId, userId);
    }

    @DeleteMapping("/{patrolId}")
    public String deletePatrol(@PathVariable(value = "patrolId") int patrolId) {

        Patrol patrol = patrolRepositoryImpl.findById(patrolId);
        if (patrol == null) throw new RuntimeException("Patrol not found: " + patrolId);
        patrolRepositoryImpl.delete(patrolId);

        return "Patrol was deleting by id: " + patrolId;
    }
}

