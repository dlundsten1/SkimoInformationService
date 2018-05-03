package se.lundsten.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.lundsten.Repository.IndividualsRepository;
import se.lundsten.model.Individual;
import se.lundsten.model.rest.CreateIndividualRequest;
import se.lundsten.model.rest.IndividualRestPath;

import java.util.UUID;


@RestController
@RequestMapping(value = IndividualRestPath.INDIVIDUAL_PATH)
public class IndividualController implements IndividualRestPath {

  @Autowired
  IndividualsRepository individualsRepository;

  @PostMapping
  public String createIndividual(@RequestBody CreateIndividualRequest request) {

    return individualsRepository.save(Individual.newBuilder()
            .withFirstName(request.getFirstName())
            .withLastName(request.getLastName())
            .withGender(request.getGender())
            .withId(UUID.randomUUID().toString())
            .build()).getId();
  }

  @GetMapping(value = IndividualRestPath.FIND_BY_ID)
  public Individual getIndividualById(@PathVariable("individual-id") String uuid) {
    return individualsRepository.findOne(uuid);
  }

  @PutMapping(value = IndividualRestPath.FIND_BY_ID)
    public Individual updateIndividualById(@PathVariable("individual-id") @RequestBody CreateIndividualRequest request, String uuid){

     Individual individual = individualsRepository.findOne(uuid);

     //Hur uppdateras objektet?
      // individual.setfirstName(request.getFirstName());
     return individual;
  }
}
