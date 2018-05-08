package se.lundsten.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.lundsten.Repository.IndividualsRepository;
import se.lundsten.model.Individual;
import se.lundsten.model.rest.CreateIndividualRequest;
import se.lundsten.model.rest.IndividualRestPath;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = IndividualRestPath.INDIVIDUAL_PATH)
public class IndividualController implements IndividualRestPath {

  @Autowired
  private
  IndividualsRepository individualsRepository;

  @RequestMapping(method = RequestMethod.POST)
  @ApiOperation(value ="Create person", notes = "Tjänst för att lägga till en person.")
  public String createIndividual(@RequestBody @Valid CreateIndividualRequest request) {
    return individualsRepository.save(Individual.newBuilder()
            .withFirstName(request.getFirstName())
            .withLastName(request.getLastName())
            .withGender(request.getGender())
            .withBirthYear(request.getBirthYear())
            .withId(UUID.randomUUID().toString())
            .build()).getId();
  }

  @RequestMapping(method = RequestMethod.GET, value = IndividualRestPath.FIND_BY_ID)
  @ApiOperation(value ="One individual", notes = "Tjänst för att hämta en person.")
  public Optional<Individual> getIndividualById(@NotNull @PathVariable("individual-id") String id) {
    return individualsRepository.findById(id);
  }

  @RequestMapping(method = RequestMethod.GET)
  @ApiOperation(value ="All individuals", notes = "Tjänst för att hämta alla personer.")
  public List<Individual> getAllIndividuals(){
      return individualsRepository.findAll();
  }

  @RequestMapping (method = RequestMethod.PUT, value = IndividualRestPath.FIND_BY_ID)
  @ApiOperation(value ="Update person", notes = "Tjänst för att uppdatera personuppgifter.")
    public String updateIndividualById(@RequestBody CreateIndividualRequest request, @NotNull @PathVariable("individual-id") String id){
     return individualsRepository.save(Individual.newBuilder()
             .withFirstName(request.getFirstName())
             .withLastName(request.getLastName())
             .withGender(request.getGender())
             .withBirthYear(request.getBirthYear())
             .withId(id)
             .build()).getId();
  }
}
