package com.atomcars.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@Getter
@NoArgsConstructor
public class CompleteUser extends BasicUser {

    @OneToMany
    private ArrayList<Document> documents;

    @OneToMany
    private ArrayList<Ride> rideList;

    @OneToMany
    private ArrayList<Violation> violationList;

    @OneToOne
    private Ride currentRide;

    public CompleteUser(BasicUser parentUser, Document document) {
        this.setId(parentUser.getId());
        this.setName(parentUser.getName());
        this.setEmail(parentUser.getEmail());
        this.addDocument(document);
    }

    public void addDocument(Document document) {
        this.documents.add(document);
    }

    public void startRide(Car car, Double destinationLatitude, Double destinationLongitude) { }

    public void endRide() {
        this.rideList.add(this.currentRide);
        this.currentRide = null;
    }

    public void addViolation(Violation violation) {
        this.violationList.add(violation);
    }

}
