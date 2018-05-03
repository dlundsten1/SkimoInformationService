package se.lundsten.Repository;


import org.springframework.stereotype.Service;
import se.lundsten.model.Competition;


import java.util.List;
import java.util.UUID;

@Service
public class CompetitionMongoRepository implements CompetitionRepository {

  @Override
  public void createCompetition(Competition competition) {

  }

  @Override
  public List<Competition> getAllCompetitions() {

    return null;
  }

  @Override
  public Competition getOneCompetition(UUID id) {

    return null;
  }
}
