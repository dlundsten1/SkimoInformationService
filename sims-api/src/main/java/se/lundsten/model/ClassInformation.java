package se.lundsten.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection ="class")
public class ClassInformation {
    @Id
  private String classId;

  private String className;

  private Double distance;

  private Double verticals;

  public List<IndividualResult> competitorResultList;

  public ClassInformation(){

  }
  private ClassInformation(Builder builder){
      setClassId(builder.classId);
      setClassName(builder.className);
      setDistance(builder.distance);
      setVerticals(builder.verticals);
      setCompetitorResultList(builder.competitorResultList);
  }

  public static Builder newBuilder(){
      return new Builder();
  }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public void setVerticals(Double verticals) {
        this.verticals = verticals;
    }

    public void setCompetitorResultList(List<IndividualResult> competitorResultList) {
        this.competitorResultList = competitorResultList;
    }

    public String getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }

    public Double getDistance() {
        return distance;
    }

    public Double getVerticals() {
        return verticals;
    }

    public List<IndividualResult> getCompetitorResultList() {
        return competitorResultList;
    }

    public static final class Builder {
        public List<IndividualResult> competitorResultList;
        private String classId;
        private String className;
        private Double distance;
        private Double verticals;

        private Builder() {
        }

        public static Builder aClassInformation() {
            return new Builder();
        }

        public Builder withClassId(String classId) {
            this.classId = classId;
            return this;
        }

        public Builder withClassName(String className) {
            this.className = className;
            return this;
        }

        public Builder withDistance(Double distance) {
            this.distance = distance;
            return this;
        }

        public Builder withVerticals(Double verticals) {
            this.verticals = verticals;
            return this;
        }

        public Builder withCompetitorResultList(List<IndividualResult> competitorResultList) {
            this.competitorResultList = competitorResultList;
            return this;
        }

        public ClassInformation build() {

            return new ClassInformation(this);
        }
    }
}
