package se.lundsten.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Competition {
  @Id
  private final String id;
  private final LocalDate date;
  private final String name;
  private final String organizer;
  private final CompetitionStatus status;
  private final List<ClassInformation> classInformation;

  private Competition(Builder builder) {
    id = builder.id;
    date = builder.date;
    name = builder.name;
    organizer = builder.organizer;
    status = builder.status;
    classInformation = builder.classInformation;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getId() {
    return id;
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

  public CompetitionStatus getStatus() {
    return status;
  }

  public List<ClassInformation> getClassInformation() {
    return classInformation;
  }

  public static final class Builder {
    private String id;
    private LocalDate date;
    private String name;
    private String organizer;
    private CompetitionStatus status;
    private List<ClassInformation> classInformation;

    private Builder() {
    }

    public Builder withId(String id) {
      this.id = id;
      return this;
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

    public Builder withStatus(CompetitionStatus status) {
      this.status = status;
      return this;
    }

    public Builder withClassInformation(List<ClassInformation> classInformation) {
      this.classInformation = classInformation;
      return this;
    }

    public Competition build() {
      return new Competition(this);
    }
  }
}
