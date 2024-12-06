package org.example.nycrestaurantexplorer.dto.commands;

import java.time.LocalDate;

public class PostRestaurantCommand {

    private String name;
    private String cuisineType;  // Tipo de culinária
    private String street;
    private String borough;
    private String zipcode;
    private String phone;
    private String currentGrade;  // Nota atual
    private LocalDate lastInspectionDate;  // Data da última inspeção

    // Construtores, getters e setters

    public PostRestaurantCommand() {
    }

    public PostRestaurantCommand(String name, String cuisineType, String street, String borough, String zipcode,
                               String phone, String currentGrade, LocalDate lastInspectionDate) {
        this.name = name;
        this.cuisineType = cuisineType;
        this.street = street;
        this.borough = borough;
        this.zipcode = zipcode;
        this.phone = phone;
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
}
