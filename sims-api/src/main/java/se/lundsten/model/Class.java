package se.lundsten.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;
@Document(collection ="class")
public class Class {
    @Id
  private UUID classId;
  private String className;
  private Double distance;
  private Double verticals;
  public List<IndividualResult> competitorResultList;


    public static final class ClassInformationBuilder {
        public List<IndividualResult> competitorResultList;
        private UUID classId;
        private String className;
        private Double distance;
        private Double verticals;

        private ClassInformationBuilder() {
        }

        public static ClassInformationBuilder aClassInformation() {
            return new ClassInformationBuilder();
        }

        public ClassInformationBuilder withClassId(UUID classId) {
            this.classId = classId;
            return this;
        }

        public ClassInformationBuilder withClassName(String className) {
            this.className = className;
            return this;
        }

        public ClassInformationBuilder withDistance(Double distance) {
            this.distance = distance;
            return this;
        }

        public ClassInformationBuilder withVerticals(Double verticals) {
            this.verticals = verticals;
            return this;
        }

        public ClassInformationBuilder withCompetitorResultList(List<IndividualResult> competitorResultList) {
            this.competitorResultList = competitorResultList;
            return this;
        }

        public Class build() {
            Class classInformation = new Class();
            classInformation.classId = this.classId;
            classInformation.verticals = this.verticals;
            classInformation.distance = this.distance;
            classInformation.className = this.className;
            classInformation.competitorResultList = this.competitorResultList;
            return classInformation;
        }
    }
}
