package se.lundsten.Repository;


import org.springframework.stereotype.Service;
import se.lundsten.model.Competition;

import java.util.List;

@Service
public class CompetitionMongoRepository implements CompetitionRepository {

  @Override
  public void createCompetition(Competition competition) {

  }

  @Override
  public List<Competition> getAllCompetitions() {
    return null;
  }
}
