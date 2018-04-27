package se.lundsten.model;

import java.util.List;
import java.util.UUID;

public class ClassInformation {
  private UUID classId;
  private String className;
  private Double distance;
  private Double verticals;
  private List<IndividualResult> competitorResultList;
}
