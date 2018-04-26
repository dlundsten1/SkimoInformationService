package se.lundsten.model;

public class Race {

  private int raceID;
  private String name;
  private double distance;
  private double verticals;
  private double duration;
  private double verticalPerMinute;
  private int individual;
  private double distanceVerticalRatio;
  private int raceRank;

  public int getRaceID() {
    return raceID;
  }

  public String getName() {
    return name;
  }

  public double getDistance() {
    return distance;
  }

  public double getVerticals() {
    return verticals;
  }

  public double getDuration() {
    return duration;
  }

  public double getVerticalPerMinute() {
    return verticalPerMinute;
  }

  public int getIndividual() {
    return individual;
  }

  public double getDistanceVerticalRatio() {
    return distanceVerticalRatio;
  }

  public int getRaceRank() {
    return raceRank;
  }

  private Race(Builder builder) {
    raceID = builder.raceID;
    name = builder.name;
    distance = builder.distance;
    verticals = builder.verticals;
    duration = builder.duration;
    verticalPerMinute = builder.verticalPerMinute;
    individual = builder.individual;
    distanceVerticalRatio = builder.distanceVerticalRatio;
    raceRank = builder.raceRank;
  }

  public static Builder newBuilder() {
    return new Builder();
  }


  public static final class Builder {
    private int raceID;
    private String name;
    private double distance;
    private double verticals;
    private double duration;
    private double verticalPerMinute;
    private int individual;
    private double distanceVerticalRatio;
    private int raceRank;

    private Builder() {
    }

    public Builder withRaceID(int raceID) {
      this.raceID = raceID;
      return this;
    }

    public Builder withName(String name) {
      this.name = name;
      return this;
    }

    public Builder withDistance(double distance) {
      this.distance = distance;
      return this;
    }

    public Builder withVerticals(double verticals) {
      this.verticals = verticals;
      return this;
    }

    public Builder withDuration(double duration) {
      this.duration = duration;
      return this;
    }

    public Builder withVerticalPerMinute(double verticalPerMinute) {
      this.verticalPerMinute = verticalPerMinute;
      return this;
    }

    public Builder withIndividual(int individual) {
      this.individual = individual;
      return this;
    }

    public Builder withDistanceVerticalRatio(double distanceVerticalRatio) {
      this.distanceVerticalRatio = distanceVerticalRatio;
      return this;
    }

    public Builder withRaceRank(int raceRank) {
      this.raceRank = raceRank;
      return this;
    }

    public Race build() {
      return new Race(this);
    }
  }
}
