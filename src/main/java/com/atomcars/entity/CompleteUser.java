package com.atomcars.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "public", catalog = "atomcars")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompleteUser extends User {

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Document> documents = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Ride> rideList = new ArrayList<>();

    @OneToMany(mappedBy = "completeUser")
    private List<Violation> violationList = new ArrayList<>();

    private Long currentRideId;

    public CompleteUser(String name, String email) {
        super(name, email);
    }

    public void addDocument(Document document) {
        this.documents.add(document);
        document.setUser(this);
    }

    public void startRide(Car car, Double destinationLatitude, Double destinationLongitude) {
        this.currentRideId = new Ride(destinationLatitude, destinationLongitude, this, car).getId();
    }

//    public void endRide() {
//        this.rideList.add(this.currentRide);
//        this.currentRide = null;
//    }

    public void addViolation(Violation violation) {
        this.violationList.add(violation);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        CompleteUser that = (CompleteUser) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
