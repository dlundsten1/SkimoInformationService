package se.lundsten.controller;

import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.lundsten.Repository.CompetitionRepository;
import se.lundsten.model.Competition;
import se.lundsten.model.IndividualResult;
import se.lundsten.model.rest.CompetitionRestPath;
import se.lundsten.model.rest.CreateCompetitionRequest;

import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = CompetitionRestPath.COMPETITION_PATH)
@Timed
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
  public String createCompetition(@RequestBody @Valid CreateCompetitionRequest request) {
    return competitionRepository.save((Competition.newBuilder()
        .withId(UUID.randomUUID().toString())
        .withDate(request.getDate())
        .withName(request.getName())
        .withOrganizer(request.getOrganizer())
        .build())).getId();
  }

  @RequestMapping(method = RequestMethod.GET)
  @ApiOperation(value ="All competitions", notes = "Tjänst för att hämta alla tävlingar.")
  public List<Competition> getCompetitions() {
    return competitionRepository.findAll();
  }

  @RequestMapping(method = RequestMethod.PUT, value = "{competition-id}")
    public String updateCompetition (@RequestBody CreateCompetitionRequest request, @NotNull @PathVariable("competition-id") String uuid){
    return  competitionRepository.save((Competition.newBuilder()
            .withId(uuid)
            .withDate(request.getDate())
            .withName(request.getName())
            .withOrganizer(request.getOrganizer())
            .build())).getId();

  }

  public String setIndividualResult(String uuid, double duration){

      //Competition competition = competitionRepository.getOneCompetition(UUID.fromString(uuid));
  return null;
     // return individualId.toString();
  }
}
