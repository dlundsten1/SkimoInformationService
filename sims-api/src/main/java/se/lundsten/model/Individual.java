package se.lundsten.model;

import java.util.UUID;

public class Individual {
  private final UUID id;
  private final String firstName;
  private final String lastName;
  private final Integer birthYear;
  private final int points;
  private final IndividualRank rank;
  private final Gender gender;

  private Individual(Builder builder) {
    id = builder.id;
    firstName = builder.firstName;
    lastName = builder.lastName;
    birthYear = builder.birthYear;
    points = builder.points;
    rank = builder.rank;
    gender = builder.gender;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public UUID getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Integer getBirthYear() {
    return birthYear;
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
    private UUID id;
    private String firstName;
    private String lastName;
    private Integer birthYear;
    private int points;
    private IndividualRank rank;
    private Gender gender;

    private Builder() {
    }

    public Builder withId(UUID id) {
      this.id = id;
      return this;
    }

    public Builder withFirstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public Builder withLastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public Builder withBirthYear(Integer birthYear) {
      this.birthYear = birthYear;
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

    public Individual build() {
      return new Individual(this);
    }
  }
}
