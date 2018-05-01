package se.lundsten.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.lundsten.model.IndividualResult;

import java.util.List;

@RestController
@RequestMapping(value = "/competition")
public class CompetitionController {

  @RequestMapping(method = RequestMethod.GET, value = "{competition-id}/{class-id}")
  public List<IndividualResult> individualResultList(
      @PathVariable("competition-id") String competitionId,
      @PathVariable("class-id") String classId) {

    return null;
  }
}
