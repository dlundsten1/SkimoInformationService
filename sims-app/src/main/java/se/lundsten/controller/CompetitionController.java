package se.lundsten.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.lundsten.Repository.CompetitionRepository;
import se.lundsten.model.Competition;
import se.lundsten.model.IndividualResult;
import se.lundsten.model.rest.CompetitionRestPath;
import se.lundsten.model.rest.CreateCompetitionRequest;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = CompetitionRestPath.COMPETITION_PATH)
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

  @RequestMapping(method = RequestMethod.GET, value = "{competition-id}")
  @ApiOperation(value ="All competitions", notes = "Tjänst för att hämta alla tävlingar.")
  public List<Competition> getCompetitions() {
    return competitionRepository.getAllCompetitions();
  }

  @RequestMapping(method = RequestMethod.PUT)
    public Competition updateCompetition (CreateCompetitionRequest  request, String uuid){
      Competition competition = competitionRepository.getOneCompetition(UUID.fromString(uuid));

     //Hur uppdaterar man detta objekt?

      return competition;
  }

  public String setIndividualResult(String uuid, double duration){

      Competition competition = competitionRepository.getOneCompetition(UUID.fromString(uuid));

      return individualId.toString();
  }
}
