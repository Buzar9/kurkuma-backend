package pl.zhr.scouting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zhr.scouting.entity.Realization;
import pl.zhr.scouting.repository.RealizationRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class RealizationController {

    @Autowired
    private RealizationRepository realizationRepositoryImpl;

    @GetMapping("/realizations")
    public List<Realization> realizationList(){

        return realizationRepositoryImpl.findAll();
    }
}
