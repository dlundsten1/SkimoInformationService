package se.lundsten.Repository;

import model.Individual;

import java.util.List;

public interface IndividualsRepository {
    Individual getIndividual(long id);
   void addIndividual(Individual individual);
    List<Individual> getAllIndividuals();
}
