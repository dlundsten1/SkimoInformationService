package se.lundsten.Repository;

import se.lundsten.model.Competition;

import java.util.List;
import java.util.UUID;


public interface CompetitionRepository {
  void createCompetition(Competition build);

  List<Competition> getAllCompetitions();

  Competition getOneCompetition(UUID id);
}
