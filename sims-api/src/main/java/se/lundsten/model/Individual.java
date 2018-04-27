package se.lundsten.model;

import java.util.UUID;

public class Individual {
  private final UUID id;
  private final String firstName;
  private final String lastName;
  private final int age;
  private final int points;
  private final int rank;
  private final Gender gender;

  public UUID getId() {
    return id;
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

  public int getRank() {
    return rank;
  }

  public Gender getGender() {
    return gender;
  }

  private Individual(Builder builder) {
    id = builder.id;
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

  public static final class Builder {
    private UUID id;
    private String firstName;
    private String lastName;
    private int age;
    private int points;
    private int rank;
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

    public Builder withAge(int age) {
      this.age = age;
      return this;
    }

    public Builder withPoints(int points) {
      this.points = points;
      return this;
    }

    public Builder withRank(int rank) {
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
