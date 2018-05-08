package se.lundsten.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "individual")
public class Individual {
  @Id
  private String id;
  private String firstName;
  private String lastName;
  private Integer birthYear;
  private int points;
  private IndividualRank rank;
  private Gender gender;

  public Individual (){

  }

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

  public String getId() {
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
    private String id;
    private String firstName;
    private String lastName;
    private Integer birthYear;
    private int points;
    private IndividualRank rank;
    private Gender gender;

    private Builder() {
    }

    public Builder withId(String id) {
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
