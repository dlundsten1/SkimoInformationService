package se.lundsten.Repository;

import org.springframework.stereotype.Component;
import model.Individual;
import model.Race;

import java.util.List;
@Component
public class IndInMemoryRepo implements IndividualsRepository {

    private List<Individual> individualList;


    @Override
    public Individual getIndividual(long id) {
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
