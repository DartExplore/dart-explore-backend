package com.dart.explore.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Amenity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long amenityId;
    @ManyToMany(mappedBy = "amenities")
    private Set<PointOfInterest> pointsOfInterest;

    private String amenity;

    public Amenity(Set<PointOfInterest> pointOfInterest, String amenity) {
        this.pointsOfInterest = pointOfInterest;
        this.amenity = amenity;
    }

    public Amenity() {

    }

    public void setAmenity(String amenity) {
        this.amenity = amenity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amenity amenity1 = (Amenity) o;
        return Objects.equals(amenityId, amenity1.amenityId) && Objects.equals(pointsOfInterest, amenity1.pointsOfInterest) && Objects.equals(amenity, amenity1.amenity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amenityId);
    }
}
