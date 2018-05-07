package se.lundsten.model.rest;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.validation.constraints.NotNull;

@JsonDeserialize(builder = CreateIndividualRequest.Builder.class)
public class CreateClassRequest {
    @NotNull
    private final String className;
    @NotNull
    private final double distance;
    @NotNull
    private final double verticals;

    private CreateClassRequest (Builder builder){
        className = builder.className;
        distance = builder.distance;
        verticals = builder.verticals;
    }

    public String getClassName() {
        return className;
    }

    public double getDistance() {
        return distance;
    }

    public double getVerticals() {
        return verticals;
    }

    public static final class Builder {
        private String className;
        private double distance;
        private double verticals;

        private Builder() {
        }

        public static Builder aCreateClassRequest() {
            return new Builder();
        }

        public Builder withClassName(String className) {
            this.className = className;
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

        public CreateClassRequest build() {

            return new CreateClassRequest(this);
        }

    }
}
