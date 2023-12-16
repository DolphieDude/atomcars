package com.atomcars.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "key")
    private Long key;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private CompleteUser user;

    public Document(Long key) {
        this.key = key;
    }
}
