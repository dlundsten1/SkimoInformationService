package se.lundsten.controller;


import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import se.lundsten.model.IndividualResult;

import java.util.List;

import io.micrometer.core.annotation.Timed;

@Timed
public class ResultController {
    @RequestMapping(method = RequestMethod.GET, value = "{competition-id}/{class-id}")
    public List<IndividualResult> individualResultList(
            @ApiParam(required = true, value = "ID på tävlingen") @PathVariable("competition-id") String competitionId,
            @ApiParam (required = true, value = "Namn på klassen") @PathVariable("class-id") String classId) {


        return null;
    }

}
