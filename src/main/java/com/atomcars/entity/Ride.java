package com.atomcars.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double destinationLatitude;

    private Double destinationLongitude;

    @OneToOne
    private CompleteUser user;

    @OneToOne
    private Car car;

    public Ride(Double destinationLatitude, Double destinationLongitude, CompleteUser user, Car car) {
        this.destinationLatitude = destinationLatitude;
        this.destinationLongitude = destinationLongitude;
        this.user = user;
        this.car = car;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
