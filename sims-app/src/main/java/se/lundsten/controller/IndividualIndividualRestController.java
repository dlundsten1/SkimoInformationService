package se.lundsten.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lundsten.Repository.IndividualsRepository;
import se.lundsten.model.Individual;
import se.lundsten.model.rest.CreateIndividualRequest;
import se.lundsten.model.rest.IndividualRestPath;

import java.util.UUID;


@RestController
@RequestMapping(value = IndividualRestPath.INDIVIDUAL_PATH)
public class IndividualIndividualRestController implements IndividualRestPath {

  @Autowired
  IndividualsRepository individualsRepository;

  @PostMapping
  public String createIndividual(@RequestBody CreateIndividualRequest request) {
    UUID indivudalUUID = UUID.randomUUID();
    individualsRepository.addIndividual(Individual.newBuilder()
        .withFirstName(request.getFirstName())
        .withLastName(request.getLastName())
        .withAge(request.getAge())
        .withGender(request.getGender())
        .withId(indivudalUUID)
        .withPoints(request.getPoints())
        .withRank(request.getRank()).build());
    return indivudalUUID.toString();
  }

  @GetMapping(value = IndividualRestPath.FIND_BY_ID)
  public Individual getIndividualById(@RequestBody UUID uuid) {
    return individualsRepository.getIndividual(uuid);
  }
}
