package org.example.nycrestaurantexplorer.dto.commands;

import java.sql.Timestamp;
import java.util.Objects;

public class PostRestaurantCommand {

    private String name;
    private String cuisineType;
    private String street;
    private String borough;
    private String zipcode;
    private String phone;
    private String cuisineDescription;
    private String currentGrade;
    private Timestamp lastInspectionDate;

    public PostRestaurantCommand() {
    }

    public PostRestaurantCommand(String name, String cuisineType, String street, String borough, String zipcode, String phone, String cuisineDescription, String currentGrade, Timestamp lastInspectionDate) {
        this.name = name;
        this.cuisineType = cuisineType;
        this.street = street;
        this.borough = borough;
        this.zipcode = zipcode;
        this.phone = phone;
        this.cuisineDescription = cuisineDescription;
        this.currentGrade = currentGrade;
        this.lastInspectionDate = lastInspectionDate;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCuisineDescription() {
        return cuisineDescription;
    }

    public void setCuisineDescription(String cuisineDescription) {
        this.cuisineDescription = cuisineDescription;
    }

    public String getCurrentGrade() {
        return currentGrade;
    }

    public void setCurrentGrade(String currentGrade) {
        this.currentGrade = currentGrade;
    }

    public Timestamp getLastInspectionDate() {
        return lastInspectionDate;
    }

    public void setLastInspectionDate(Timestamp lastInspectionDate) {
        this.lastInspectionDate = lastInspectionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostRestaurantCommand that = (PostRestaurantCommand) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getCuisineType(), that.getCuisineType()) && Objects.equals(getStreet(), that.getStreet()) && Objects.equals(getBorough(), that.getBorough()) && Objects.equals(getZipcode(), that.getZipcode()) && Objects.equals(getPhone(), that.getPhone()) && Objects.equals(getCuisineDescription(), that.getCuisineDescription()) && Objects.equals(getCurrentGrade(), that.getCurrentGrade()) && Objects.equals(getLastInspectionDate(), that.getLastInspectionDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCuisineType(), getStreet(), getBorough(), getZipcode(), getPhone(), getCuisineDescription(), getCurrentGrade(), getLastInspectionDate());
    }
}
