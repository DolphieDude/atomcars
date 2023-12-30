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

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "file_data", columnDefinition = "bytea")
    private byte[] fileData;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private CompleteUser user;
}
