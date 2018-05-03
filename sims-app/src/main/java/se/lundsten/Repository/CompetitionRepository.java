package se.lundsten.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import se.lundsten.model.Competition;

import java.util.List;
import java.util.UUID;


public interface CompetitionRepository extends MongoRepository {
  void createCompetition(Competition build);

  List<Competition> getAllCompetitions();

  Competition getOneCompetition(UUID id);
}
