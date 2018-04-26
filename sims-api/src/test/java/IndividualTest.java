import org.junit.Test;
import se.lundsten.model.Gender;
import se.lundsten.model.Individual;

public class IndividualTest {

  @Test
  public void testCreateIndividual() {
    Individual individual = Individual
        .newBuilder()
        .withAge(12)
        .withFemale(Gender.FEMALE)
        .
        .build();

  }
}
