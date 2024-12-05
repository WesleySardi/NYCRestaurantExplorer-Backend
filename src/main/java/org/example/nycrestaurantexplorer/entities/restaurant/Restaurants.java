package org.example.nycrestaurantexplorer.entities.restaurant;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.example.nycrestaurantexplorer.entities.inspection.Inspections;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Restaurants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String cuisineType;
    private String streetAddress;
    private String borough;
    private String zipcode;
    private String phoneNumber;
    private String currentGrade;
    private LocalDate lastInspectionDate;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Inspections> inspections;

    public Restaurants() {
    }

    public Restaurants(Integer id, String name, String cuisineType, String streetAddress, String borough, String zipcode, String phoneNumber, String currentGrade, LocalDate lastInspectionDate, Timestamp createdAt, Timestamp updatedAt, List<Inspections> inspections) {
        this.id = id;
        this.name = name;
        this.cuisineType = cuisineType;
        this.streetAddress = streetAddress;
        this.borough = borough;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
        this.currentGrade = currentGrade;
        this.lastInspectionDate = lastInspectionDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.inspections = inspections;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCurrentGrade() {
        return currentGrade;
    }

    public void setCurrentGrade(String currentGrade) {
        this.currentGrade = currentGrade;
    }

    public LocalDate getLastInspectionDate() {
        return lastInspectionDate;
    }

    public void setLastInspectionDate(LocalDate lastInspectionDate) {
        this.lastInspectionDate = lastInspectionDate;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Inspections> getInspections() {
        return inspections;
    }

    public void setInspections(List<Inspections> inspections) {
        this.inspections = inspections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurants that = (Restaurants) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getCuisineType(), that.getCuisineType()) && Objects.equals(getStreetAddress(), that.getStreetAddress()) && Objects.equals(getBorough(), that.getBorough()) && Objects.equals(getZipcode(), that.getZipcode()) && Objects.equals(getPhoneNumber(), that.getPhoneNumber()) && Objects.equals(getCurrentGrade(), that.getCurrentGrade()) && Objects.equals(getLastInspectionDate(), that.getLastInspectionDate()) && Objects.equals(getCreatedAt(), that.getCreatedAt()) && Objects.equals(getUpdatedAt(), that.getUpdatedAt()) && Objects.equals(getInspections(), that.getInspections());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCuisineType(), getStreetAddress(), getBorough(), getZipcode(), getPhoneNumber(), getCurrentGrade(), getLastInspectionDate(), getCreatedAt(), getUpdatedAt(), getInspections());
    }
}


