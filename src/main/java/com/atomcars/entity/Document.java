package com.atomcars.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
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

    @Lob
    @Column(name = "file_data", columnDefinition = "bytea")
    private byte[] fileData;


    public Document(Long key) {
        this.key = key;
    }
}
