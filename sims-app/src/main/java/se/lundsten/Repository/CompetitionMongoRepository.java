package se.lundsten.Repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import se.lundsten.model.Competition;


import java.util.List;
import java.util.UUID;

@Component
public abstract class CompetitionMongoRepository implements CompetitionRepository {

  @Autowired
  private List<Competition> competitions;
  @Override

  public void createCompetition(Competition competition) {
    competitions.save(competition);
  }

  @Override
  public List<Competition> getAllCompetitions() {

    return competitions.findAll();
  }

  @Override
  public Competition getOneCompetition(UUID id) {

    return competitions.;
  }

}
