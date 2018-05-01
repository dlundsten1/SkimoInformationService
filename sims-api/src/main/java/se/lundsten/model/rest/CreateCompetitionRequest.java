package se.lundsten.model.rest;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDate;

@JsonDeserialize(builder = CreateCompetitionRequest.Builder.class)
public class CreateCompetitionRequest {
  private final LocalDate date;
  private final String name;
  private final String organizer;

  private CreateCompetitionRequest(Builder builder) {
    date = builder.date;
    name = builder.name;
    organizer = builder.organizer;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public LocalDate getDate() {
    return date;
  }

  public String getName() {
    return name;
  }

  public String getOrganizer() {
    return organizer;
  }


  public static final class Builder {
    private LocalDate date;
    private String name;
    private String organizer;

    private Builder() {
    }

    public Builder withDate(LocalDate date) {
      this.date = date;
      return this;
    }

    public Builder withName(String name) {
      this.name = name;
      return this;
    }

    public Builder withOrganizer(String organizer) {
      this.organizer = organizer;
      return this;
    }

    public CreateCompetitionRequest build() {
      return new CreateCompetitionRequest(this);
    }
  }
}