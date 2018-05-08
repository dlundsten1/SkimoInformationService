package se.lundsten.controller;

import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.lundsten.Repository.IndividualsRepository;
import se.lundsten.model.Individual;
import se.lundsten.model.rest.CreateIndividualRequest;
import se.lundsten.model.rest.IndividualRestPath;

import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping(value = IndividualRestPath.INDIVIDUAL_PATH)
@Timed
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
  public Optional<Individual>getIndividualById(@PathVariable("individual-id") String uuid) {
    return individualsRepository.findById(uuid);
  }

  @PutMapping(value = IndividualRestPath.FIND_BY_ID)
    public Optional<Individual> updateIndividualById(@PathVariable("individual-id") @RequestBody CreateIndividualRequest request, String uuid){

     Optional<Individual> individual = individualsRepository.findById(uuid);

     //Hur uppdateras objektet?
      // individual.setfirstName(request.getFirstName());
     return individual;
  }
}
