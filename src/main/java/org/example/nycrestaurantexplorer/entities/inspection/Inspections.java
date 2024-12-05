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
    private Date inspectionDate;
    private String grade;
    private String comments;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Inspections() {
    }

    public Inspections(Integer id, Restaurants restaurant, Date inspectionDate, String grade, String comments, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.restaurant = restaurant;
        this.inspectionDate = inspectionDate;
        this.grade = grade;
        this.comments = comments;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public Date getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(Date inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inspections that = (Inspections) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getRestaurant(), that.getRestaurant()) && Objects.equals(getInspectionDate(), that.getInspectionDate()) && Objects.equals(getGrade(), that.getGrade()) && Objects.equals(getComments(), that.getComments()) && Objects.equals(getCreatedAt(), that.getCreatedAt()) && Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRestaurant(), getInspectionDate(), getGrade(), getComments(), getCreatedAt(), getUpdatedAt());
    }
}
