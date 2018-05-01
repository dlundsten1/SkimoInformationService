package se.lundsten.model.rest;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import se.lundsten.model.Gender;
import se.lundsten.model.IndividualRank;

@JsonDeserialize(builder = CreateIndividualRequest.Builder.class)
public class CreateIndividualRequest {
  private final String firstName;
  private final String lastName;
  private final int age;
  private final int points;
  private final IndividualRank rank;
  private final Gender gender;

  private CreateIndividualRequest(Builder builder) {
    firstName = builder.firstName;
    lastName = builder.lastName;
    age = builder.age;
    points = builder.points;
    rank = builder.rank;
    gender = builder.gender;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getAge() {
    return age;
  }

  public int getPoints() {
    return points;
  }

  public IndividualRank getRank() {
    return rank;
  }

  public Gender getGender() {
    return gender;
  }


  public static final class Builder {
    private String firstName;
    private String lastName;
    private int age;
    private int points;
    private IndividualRank rank;
    private Gender gender;

    private Builder() {
    }

    public Builder withFirstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public Builder withLastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public Builder withAge(int age) {
      this.age = age;
      return this;
    }

    public Builder withPoints(int points) {
      this.points = points;
      return this;
    }

    public Builder withRank(IndividualRank rank) {
      this.rank = rank;
      return this;
    }

    public Builder withGender(Gender gender) {
      this.gender = gender;
      return this;
    }

    public CreateIndividualRequest build() {
      return new CreateIndividualRequest(this);
    }
  }
}
