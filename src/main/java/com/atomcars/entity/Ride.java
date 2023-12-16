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
    @Column(name = "id")
    private Long id;

    @Column(name = "destination_latitude")
    private Double destinationLatitude;

    @Column(name = "destination_longitude")
    private Double destinationLongitude;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private CompleteUser user;

    @ManyToOne
    @JoinColumn(name = "car_id")
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
