package se.lundsten.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lundsten.Repository.IndInMemoryRepo;
import se.lundsten.Repository.IndividualsRepository;
import model.Individual;

import java.util.List;

@RestController
public class RankController {
    @Autowired
    IndividualsRepository individualsRepository;
    IndInMemoryRepo ind;


    @RequestMapping("/")
    public List<Individual> individualList() {

        return ind.getAllIndividuals();
    }
    @RequestMapping("/test")
    public String test(){

        return ind.toString();
    }
    @RequestMapping("/add")
    public void addOne() {
        long counter = 0;
        Individual individual = new Individual(counter, "David","Lundsten", 1988,0,0,false);

        ind.addIndividual(individual);
        System.out.println("tillagd: "+ ind.getIndividual(0).getFirstName());

    }
}
