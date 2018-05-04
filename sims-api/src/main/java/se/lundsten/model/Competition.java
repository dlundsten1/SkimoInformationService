package se.lundsten.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "competition")
public class Competition {
  @Id
  private String id;

  @Field
  private LocalDateTime date;

  @Field
  private String name;

  @Field
  private String organizer;
  @Field
  private CompetitionStatus status;
  @Field
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

  public void setId(String id) {
    this.id = id;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setOrganizer(String organizer) {
    this.organizer = organizer;
  }

  public void setStatus(CompetitionStatus status) {
    this.status = status;
  }

  public void setClassInformation(List<ClassInformation> classInformation) {
    this.classInformation = classInformation;
  }

  public String getId() {
    return id;
  }

  public LocalDateTime getDate() {
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
    private LocalDateTime date;
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

    public Builder withDate(LocalDateTime date) {
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
