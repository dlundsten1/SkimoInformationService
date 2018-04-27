package se.lundsten;

import se.lundsten.model.Individual;
import se.lundsten.model.Race;

import java.util.List;

public class TestDataGenerator {
  long counter = 0;

  List<Race> raceList;

  Individual individual = Individual.newBuilder()
      .withAge(30)
      .withFirstName("David")
      .withLastName("Lundsten")
      //.withRank(1)
      .build();
}

