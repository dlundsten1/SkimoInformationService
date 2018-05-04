package se.lundsten.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.lundsten.Repository.CompetitionRepository;
import se.lundsten.model.Competition;
import se.lundsten.model.rest.CompetitionRestPath;
import se.lundsten.model.rest.CreateCompetitionRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = CompetitionRestPath.COMPETITION_PATH)
public class CompetitionController {

  @Autowired
  CompetitionRepository competitionRepository;

  @RequestMapping(method = RequestMethod.POST)
  public String createCompetition(@RequestBody @Valid CreateCompetitionRequest request) {
    return competitionRepository.save((Competition.newBuilder()
        .withId(UUID.randomUUID().toString())
        .withDate(request.getDate())
        .withName(request.getName())
        .withOrganizer(request.getOrganizer())
        .build())).getId();
  }
    @RequestMapping(method = RequestMethod.GET, value = "{competition-id}")
    @ApiOperation(value ="One competition", notes = "Tjänst för att hämta en tävling.")
    public Optional<Competition> getOneCompetition(@NotNull @PathVariable("competition-id") String id) {

        return competitionRepository.findById(id);
    }
  @RequestMapping(method = RequestMethod.GET)
  @ApiOperation(value ="All competitions", notes = "Tjänst för att hämta alla tävlingar.")
  public List<Competition> getAllCompetitions() {
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

}
