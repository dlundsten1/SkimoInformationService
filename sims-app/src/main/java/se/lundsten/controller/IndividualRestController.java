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
public class IndividualRestController implements IndividualRestPath {

  @Autowired
  IndividualsRepository individualsRepository;

  @PostMapping
  public String createIndividual(@RequestBody CreateIndividualRequest request) {
    UUID individualId = UUID.randomUUID();
    individualsRepository.addIndividual(Individual.newBuilder()
        .withFirstName(request.getFirstName())
        .withLastName(request.getLastName())
        .withGender(request.getGender())
        .withId(individualId)
        .build());
    return individualId.toString();
  }

  @GetMapping(value = IndividualRestPath.FIND_BY_ID)
  public Individual getIndividualById(@PathVariable("individual-id") String uuid) {
    return individualsRepository.getIndividual(UUID.fromString(uuid));
  }

  @PutMapping(value = IndividualRestPath.FIND_BY_ID)
    public Individual updateIndividualById(@PathVariable("individual-id") @RequestBody CreateIndividualRequest request, String uuid){

     Individual individual = individualsRepository.getIndividual(UUID.fromString(uuid));

     //Hur uppdateras objektet?
      // individual.setfirstName(request.getFirstName());
     return individual;
  }
}
