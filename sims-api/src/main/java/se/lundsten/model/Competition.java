package se.lundsten.model;

import java.time.LocalDate;
import java.util.List;

public class Competition {
  private LocalDate date;
  private String name;
  private String organizer;
  private CompetitionStatus status;
  private List<ClassInformation> classInformation;
}
