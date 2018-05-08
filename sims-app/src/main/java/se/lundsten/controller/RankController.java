package se.lundsten.controller;

import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lundsten.Repository.IndividualsRepository;
import se.lundsten.model.Individual;
import se.lundsten.model.rest.CreateIndividualRequest;

import java.util.List;

@RestController
@Timed
public class RankController {
  @Autowired
  IndividualsRepository individualsRepository;


  @RequestMapping("/")
  public List<Individual> individualList() {

     // return individualsRepository.getAllIndividuals();
    return null;
  }

  @RequestMapping("/test")
  public String test(){

      return individualsRepository.toString();
  }

  @RequestMapping("/add")
  public void addOne(CreateIndividualRequest individual) {
  }
}
