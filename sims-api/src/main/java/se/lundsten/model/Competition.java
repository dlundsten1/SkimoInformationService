package se.lundsten.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDate;
import java.util.List;

@Document(collection = "competition")
public class Competition {
  @Id
  private String id;

  private LocalDate date;

  private String name;

  private String organizer;

  private CompetitionStatus status;

  private List<ClassInformation> classInformation;

  public Competition (){

  }
  
  private Competition(Builder builder) {
    setId(builder.id);
    setDate(builder.date);
    setName(builder.name);
    setOrganizer(builder.organizer);
    setStatus(builder.status);
    setClassInformation(builder.classInformation);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  private void setId(String id) {
    this.id = id;
  }

  private void setDate(LocalDate date) {
    this.date = date;
  }

  private void setName(String name) {
    this.name = name;
  }

  private void setOrganizer(String organizer) {
    this.organizer = organizer;
  }

  private void setStatus(CompetitionStatus status) {
    this.status = status;
  }

  public void setClassInformation(List<ClassInformation> classInformation) {
    this.classInformation = classInformation;
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
