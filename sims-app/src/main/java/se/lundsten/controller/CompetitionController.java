package se.lundsten.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.lundsten.Repository.CompetitionRepository;
import se.lundsten.model.ClassInformation;
import se.lundsten.model.Competition;
import se.lundsten.model.rest.CompetitionRestPath;
import se.lundsten.model.rest.CreateClassRequest;
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
    public String updateCompetition (@RequestBody CreateCompetitionRequest request, @NotNull @PathVariable("competition-id") String id){
    return  competitionRepository.save((Competition.newBuilder()
            .withId(id)
            .withDate(request.getDate())
            .withName(request.getName())
            .withOrganizer(request.getOrganizer())
            .build())).getId();
  }
  public List<ClassInformation> getAllClasses(){


      return null;
  }

  @RequestMapping(value = CompetitionRestPath.COMPETITION_ID+"/class", method = RequestMethod.POST)
  public String addClass (@RequestBody List<CreateClassRequest> request, @NotNull @PathVariable("competition-id") String id){
    List<ClassInformation> classList = null;

    for(int i=0; i<request.size(); i++){
          CreateClassRequest c = request.get(i);
          ClassInformation classInformation = new ClassInformation();
          classInformation.setVerticals(c.getVerticals());
          classInformation.setDistance(c.getDistance());
          classInformation.setClassName(c.getClassName());
          classInformation.setClassId(UUID.randomUUID().toString());
          classList.add(classInformation);
         // classList.add(ClassInformation.newBuilder()
         //         .withClassId(UUID.randomUUID().toString())
           //       .withClassName(c.getClassName())
           //       .withDistance(c.getDistance())
            //      .withVerticals(c.getVerticals()).build());
    }
    Competition competition = competitionRepository.findById(id).get();
    competition.setClassInformation(classList);

      return  id;
  }

}
