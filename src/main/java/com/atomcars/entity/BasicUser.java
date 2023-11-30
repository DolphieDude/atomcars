package com.atomcars.entity;

import jakarta.persistence.Entity;

@Entity
public class BasicUser extends User {
    public CompleteUser uploadDocument(Document document) {
        return new CompleteUser(this, document);
    }
}
