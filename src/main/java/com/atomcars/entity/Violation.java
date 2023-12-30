package com.atomcars.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Violation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "penalty")
    private String penalty;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private CompleteUser completeUser;

    public Violation(String description) {
        this.description = description;
    }
}
