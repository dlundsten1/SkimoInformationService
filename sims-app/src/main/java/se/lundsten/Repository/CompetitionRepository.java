package se.lundsten.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import se.lundsten.model.Competition;

public interface CompetitionRepository extends MongoRepository<Competition, String> {

}
