package se.lundsten.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.lundsten.Repository.CompetitionRepository;
import se.lundsten.model.Competition;
import se.lundsten.model.IndividualResult;
import se.lundsten.model.rest.CreateCompetitionRequest;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/competition")
public class CompetitionController {

  @Autowired
  CompetitionRepository competitionRepository;

  @RequestMapping(method = RequestMethod.GET, value = "{competition-id}/{class-id}")
  public List<IndividualResult> individualResultList(
      @ApiParam (required = true, value = "ID på tävlingen") @PathVariable("competition-id") String competitionId,
      @ApiParam (required = true, value = "Namn på klassen") @PathVariable("class-id") String classId) {

    return null;
  }

  @RequestMapping(method = RequestMethod.POST)
  public String createCompetition(CreateCompetitionRequest request) {
    UUID compeitionId = UUID.randomUUID();
    competitionRepository.createCompetition(Competition.newBuilder()
        .withId(compeitionId)
        .withDate(request.getDate())
        .withName(request.getName())
        .withOrganizer(request.getOrganizer())
        .build());
    return compeitionId.toString();
  }

  @RequestMapping(method = RequestMethod.GET)
  @ApiOperation(value ="All competitions", notes = "Tjänst för att hämta alla tävlingar.")
  public List<Competition> getCompetitions() {
    return competitionRepository.getAllCompetitions();
  }
}
