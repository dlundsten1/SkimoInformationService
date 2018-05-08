package se.lundsten.controller;

import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.lundsten.Repository.CompetitionRepository;
import se.lundsten.model.ClassInformation;
import se.lundsten.model.Competition;
import se.lundsten.model.rest.CompetitionRestPath;
import se.lundsten.model.rest.CreateClassRequest;
import se.lundsten.model.rest.CreateCompetitionRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = CompetitionRestPath.COMPETITION_PATH)
@Timed
public class CompetitionController {

  @Autowired
  private
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

  @RequestMapping(method = RequestMethod.GET, value = CompetitionRestPath.COMPETITION_ID)
  @ApiOperation(value ="One competition", notes = "Tjänst för att hämta en tävling.")
  public Optional<Competition> getCompetitionById(@NotNull @PathVariable("competition-id") String id) {
        return competitionRepository.findById(id);
  }

  @RequestMapping(method = RequestMethod.GET)
  @ApiOperation(value ="All competitions", notes = "Tjänst för att hämta alla tävlingar.")
    public List<Competition> getAllCompetitions() {
    return competitionRepository.findAll();
  }

  @RequestMapping(method = RequestMethod.PUT, value = CompetitionRestPath.COMPETITION_ID)
  @ApiOperation(value ="Update competition", notes = "Tjänst för att uppdatera en tävling.")
    public String updateCompetition (@RequestBody CreateCompetitionRequest request, @NotNull @PathVariable("competition-id") String id){
    return competitionRepository.save((Competition.newBuilder()
            .withId(id)
            .withDate(request.getDate())
            .withName(request.getName())
            .withOrganizer(request.getOrganizer())
            .build())).getId();
  }

  @RequestMapping(method = RequestMethod.GET, value = CompetitionRestPath.COMPETITION_ID+"/class")
  @ApiOperation(value ="Get classes", notes = "Tjänst för att hämta alla klasser för en specifik tävling.")
    public List<ClassInformation> getClasses(@NotNull @PathVariable("competition-id") String id){
    Optional<Competition> c = competitionRepository.findById(id);
    return c.get().getClassInformation();
  }

  @RequestMapping(value = CompetitionRestPath.COMPETITION_ID+"/class", method = RequestMethod.POST)
  @ApiOperation(value ="Add classes", notes = "Tjänst för att lägga till klasser för en tävling")
    public String addClasses (@RequestBody List<CreateClassRequest> request, @NotNull @PathVariable("competition-id") String id){
    Competition competition = competitionRepository.findById(id).get();
    List<ClassInformation> classList = competition.getClassInformation();

    for(int i=0; i<request.size(); i++){
          CreateClassRequest c = request.get(i);
          classList.add(ClassInformation.newBuilder()
                  .withClassId(UUID.randomUUID().toString())
                  .withClassName(c.getClassName())
                  .withDistance(c.getDistance())
                  .withVerticals(c.getVerticals()).build());
    }
    competition.setClassInformation(classList);
    competitionRepository.save(competition);
    return  id;
  }


}
