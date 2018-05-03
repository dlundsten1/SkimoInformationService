package se.lundsten.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import se.lundsten.model.Individual;

public interface IndividualsRepository extends MongoRepository<Individual, String>{
}
