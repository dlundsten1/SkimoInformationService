package se.lundsten.model;

public class Race {

    int raceID;
    String name;
    double distance;
    double verticals;
    double duration;
    double verticalPerMinute;
    int individual;
    double distanceVerticalRatio;
    int raceRank;

     public Race(int raceID, double verticals, int duration, int individual, int raceRank) {
        this.distance = distance;
        this.raceID = raceID;
        this.verticals = verticals;
        this.individual = individual;
        this.duration = duration;
        this.raceRank = raceRank;
    }

    public int getRaceID() {
        return raceID;
    }

    public void setRaceID(int raceID) {
        this.raceID = raceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getVerticals() {
        return verticals;
    }

    public void setVerticals(double verticals) {
        this.verticals = verticals;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getVerticalPerMinute() {
        return verticalPerMinute;
    }

    public void setVerticalPerMinute(double verticalPerMinute) {
        this.verticalPerMinute = verticalPerMinute;
    }

    public int getIndividual() {
        return individual;
    }

    public void setIndividual(int individual) {
        this.individual = individual;
    }

    public double getDistanceVerticalRatio() {
        return distanceVerticalRatio;
    }

    public void setDistanceVerticalRatio(double distanceVerticalRatio) {
        this.distanceVerticalRatio = distanceVerticalRatio;
    }

    public int getRaceRank() {
        return raceRank;
    }

    public void setRaceRank(int raceRank) {
        this.raceRank = raceRank;
    }
}
