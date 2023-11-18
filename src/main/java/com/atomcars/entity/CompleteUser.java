package com.atomcars.entity;

import java.util.ArrayList;

public class CompleteUser extends BasicUser {
    Document document;

    ArrayList<Ride> rideList;
    ArrayList<Violation> violationList;

    Ride currentRide;

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public ArrayList<Ride> getRideList() {
        return rideList;
    }

    public ArrayList<Violation> getViolationList() {
        return violationList;
    }

    public Ride getCurrentRide() {
        return currentRide;
    }

    public void startRide(Car car, Double destinationLatitude, Double destinationLongitude) { }

    public void endRide() { }

    public void addViolation(Violation violation) { }

}
