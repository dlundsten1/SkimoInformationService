package se.lundsten.model.rest;

import se.lundsten.model.Individual;

public class CreateIndividualRequest {
    public Individual individual(){
      Individual individual = Individual.newBuilder().build();

      
        return individual;
    }





}
