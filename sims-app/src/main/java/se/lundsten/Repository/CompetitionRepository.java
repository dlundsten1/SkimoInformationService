package se.lundsten.Repository;

import se.lundsten.model.Competition;

import java.util.List;


public interface CompetitionRepository {
  void createCompetition(Competition build);

  List<Competition> getAllCompetitions();
}
