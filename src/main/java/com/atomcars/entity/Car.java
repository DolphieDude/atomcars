package com.atomcars.entity;

import java.util.ArrayList;

public class Car {
    Long id;

    Double latitude;
    Double longitude;

    Boolean isStolen;

    ArrayList<Ride> rideList;

    Ride currentRide;

    public Long getId() {
        return id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Boolean getStolen() {
        return isStolen;
    }

    public void setStolen(Boolean stolen) {
        isStolen = stolen;
    }

    public ArrayList<Ride> getRideList() {
        return rideList;
    }

    public Ride getCurrentRide() {
        return currentRide;
    }

    public void setCurrentRide(Ride currentRide) {
        this.currentRide = currentRide;
    }

    public void endRide() {}
}
