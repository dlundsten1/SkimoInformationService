package se.lundsten.Repository;


import se.lundsten.model.Individual;

import java.util.List;
import java.util.UUID;

public interface IndividualsRepository {
  Individual getIndividual(UUID id);
  void addIndividual(Individual individual);
  List<Individual> getAllIndividuals();
}
