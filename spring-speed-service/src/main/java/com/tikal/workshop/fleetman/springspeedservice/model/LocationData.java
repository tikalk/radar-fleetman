package com.tikal.workshop.fleetman.springspeedservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationData {
    @JsonProperty
    String imei;
    @JsonProperty
    String sentTime;
    @JsonProperty
    double lat;
    @JsonProperty
    double lon;

    public String getImei() {
        return imei;
    }


    public String getSentTime() {
        return sentTime;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    @Override
    public String toString() {
        return "LocationData{" +
                "imei='" + imei + '\'' +
                ", sentTime='" + sentTime + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
