package se.lundsten;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lundsten.Repository.IndInMemoryRepo;
import se.lundsten.Repository.IndividualsRepository;
import se.lundsten.model.Individual;
import se.lundsten.model.Race;
import se.lundsten.Repository.IndividualsRepository;

import java.util.List;

public class TestDataGenerator {
    long counter = 0;



    List<Race> raceList;

    Individual individual = new Individual(counter, "David","Lundsten", 1988,0,0,false);


}

