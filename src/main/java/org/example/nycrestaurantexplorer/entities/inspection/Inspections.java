package org.example.nycrestaurantexplorer.entities.inspection;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.example.nycrestaurantexplorer.entities.restaurant.Restaurants;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
public class Inspections {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonBackReference
    private Restaurants restaurant;
    private String grade;
    private Timestamp inspectionDate;

    private String criticalFlag;
    private Timestamp recordDate;

    public Inspections(Integer id, Restaurants restaurant, String grade, Timestamp inspectionDate, String criticalFlag, Timestamp recordDate) {
        this.id = id;
        this.restaurant = restaurant;
        this.grade = grade;
        this.inspectionDate = inspectionDate;
        this.criticalFlag = criticalFlag;
        this.recordDate = recordDate;
    }

    public Inspections() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Restaurants getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurants restaurant) {
        this.restaurant = restaurant;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Timestamp getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(Timestamp inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getCriticalFlag() {
        return criticalFlag;
    }

    public void setCriticalFlag(String criticalFlag) {
        this.criticalFlag = criticalFlag;
    }

    public Timestamp getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Timestamp recordDate) {
        this.recordDate = recordDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inspections that = (Inspections) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getRestaurant(), that.getRestaurant()) && Objects.equals(getGrade(), that.getGrade()) && Objects.equals(getInspectionDate(), that.getInspectionDate()) && Objects.equals(getCriticalFlag(), that.getCriticalFlag()) && Objects.equals(getRecordDate(), that.getRecordDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRestaurant(), getGrade(), getInspectionDate(), getCriticalFlag(), getRecordDate());
    }
}
