package com.atomcars.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long key;

    @ManyToOne
    private CompleteUser user;
}
