package se.lundsten.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lundsten.Repository.IndividualsRepository;
import se.lundsten.model.CreateIndividualRequest;
import se.lundsten.model.Individual;

import java.util.List;

@RestController
public class RankController {
  @Autowired
  IndividualsRepository individualsRepository;


  @RequestMapping("/")
  public List<Individual> individualList() {

      return individualsRepository.getAllIndividuals();
  }

  @RequestMapping("/test")
  public String test(){

      return individualsRepository.toString();
  }

  @RequestMapping("/add")
  public void addOne(CreateIndividualRequest individual) {
  }
}
