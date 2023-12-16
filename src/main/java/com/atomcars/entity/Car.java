package com.atomcars.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;

@Entity
@Getter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "is_stolen")
    private Boolean isStolen;

    @OneToMany(mappedBy = "car")
    private ArrayList<Ride> rideList;

    @OneToOne
    @JoinColumn(name = "current_ride_id")
    private Ride currentRide;

    public void setId(Long id) {
        this.id = id;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setStolen(Boolean stolen) {
        isStolen = stolen;
    }

    public void setCurrentRide(Ride currentRide) {
        this.currentRide = currentRide;
    }

    public void endRide() {
        this.rideList.add(this.currentRide);
        this.currentRide = null;
    }
}
