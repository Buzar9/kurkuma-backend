package pl.zhr.scouting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.zhr.scouting.entity.Realization;
import pl.zhr.scouting.repository.RealizationRepository;

import java.util.List;

@RestController
@RequestMapping("/realizations")
@CrossOrigin(origins = "*")
public class RealizationController {

    @Autowired
    private RealizationRepository realizationRepositoryImpl;

    @GetMapping
    public List<Realization> realizationList(){

        return realizationRepositoryImpl.findAll();
    }

    @GetMapping("{realizationId}")
    public Realization findSingleRealization(@PathVariable int realizationId) {

        return realizationRepositoryImpl.findById(realizationId);
    }

    @PostMapping("/user{userId}/quest{questId}")
    public void saveRealization(@PathVariable int userId,
                                @PathVariable int questId,
                                @RequestBody Realization tempRealization) {

        tempRealization.setRealizationId(0);
        realizationRepositoryImpl.saveOrUpdate(tempRealization, userId, questId);
    }


//    todo: błąd: zduplikowanie wpisu w tabeli "quest_realization"
    @PutMapping("{realizationId}/user{userId}/quest{questId}")
    public void updateRealization(@PathVariable int realizationId,
                                  @PathVariable int userId,
                                  @PathVariable int questId,
                                  @RequestBody Realization tempRealization){

        tempRealization.setRealizationId(realizationId);
        realizationRepositoryImpl.saveOrUpdate(tempRealization, userId, questId);
    }

    @DeleteMapping("{realizationId}")
    public void deleteRealization(@PathVariable int realizationId){

        realizationRepositoryImpl.delete(realizationId);
    }
}
