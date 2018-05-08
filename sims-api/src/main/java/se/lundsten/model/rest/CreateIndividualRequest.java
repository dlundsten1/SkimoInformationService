package se.lundsten.model.rest;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import se.lundsten.model.Gender;
import javax.validation.constraints.NotNull;

@JsonDeserialize(builder = CreateIndividualRequest.Builder.class)
public class CreateIndividualRequest {
  @NotNull
  private final String firstName;
  @NotNull
  private final String lastName;
  @NotNull
  private final Integer birthYear;
  @NotNull
  private final Gender gender;

  private CreateIndividualRequest(Builder builder) {
    firstName = builder.firstName;
    lastName = builder.lastName;
    birthYear = builder.birthYear;
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

  public Integer getBirthYear() {
    return birthYear;
  }

  public Gender getGender() {
    return gender;
  }


  public static final class Builder {
    private String firstName;
    private String lastName;
    private Integer birthYear;
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

    public Builder withBirthYear(Integer birthYear) {
      this.birthYear = birthYear;
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
