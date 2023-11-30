package com.atomcars.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
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

    public void setId(Long id) {
        this.id = id;
    }
}
