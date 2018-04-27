package se.lundsten.Repository;

import org.springframework.stereotype.Component;
import se.lundsten.model.Individual;

import java.util.List;
import java.util.UUID;

@Component
public class IndInMemoryRepo implements IndividualsRepository {

    private List<Individual> individualList;


    @Override
    public Individual getIndividual(UUID id) {
        for(Individual individual : individualList){
            if(individual.getId() == id){
                return individual;
            }
        }
        return null;
    }

    @Override
    public void addIndividual(Individual individual) {
            individualList.add(individual);
    }

    @Override
    public List<Individual> getAllIndividuals() {
        return individualList;
    }
}
