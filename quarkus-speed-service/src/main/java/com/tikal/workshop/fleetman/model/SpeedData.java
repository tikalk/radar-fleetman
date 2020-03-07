package com.tikal.workshop.fleetman.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpeedData {
    @JsonProperty
    Integer speed;

    @JsonProperty
    Integer beam;

    public Integer getSpeed() {
        return speed;
    }

    public Integer getBeam() {
        return beam;
    }

    public SpeedData() {
    }

    public SpeedData(Integer speed, Integer beam) {
        this.speed = speed;
        this.beam = beam;
    }


    @Override
    public String toString() {
        return "SpeedData{" +
                "speed=" + speed +
                ", beam=" + beam +
                '}';
    }
}
