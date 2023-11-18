package com.atomcars.entity;

public class Ride {
    Long id;

    Double destinationLatitude;
    Double destinationLongitude;

    CompleteUser user;
    Car car;

    public Long getId() {
        return id;
    }

    public Double getDestinationLatitude() {
        return destinationLatitude;
    }

    public Double getDestinationLongitude() {
        return destinationLongitude;
    }

    public CompleteUser getUser() {
        return user;
    }

    public Car getCar() {
        return car;
    }
}
