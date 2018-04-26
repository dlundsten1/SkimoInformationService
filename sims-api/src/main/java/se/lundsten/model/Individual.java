package se.lundsten.model;

public class Individual {
  long id;
  String firstName;
  String lastName;
  int age;
  int points;
  int rank;
  Gender gender;

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
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private int points;
    private int rank;
    private Gender gender;

    private Builder() {
    }

    public Builder withId(long id) {
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

    public Builder withFemale(Gender female) {
      this.gender = female;
      return this;
    }

    public Individual build() {
      return new Individual(this);
    }
  }
}
