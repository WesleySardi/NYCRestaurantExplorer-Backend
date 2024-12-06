package org.example.nycrestaurantexplorer.dto.commands;

import java.util.List;
import java.util.Objects;

public class PutRestaurantCommand {

    private String name;

    private String borough;

    private String street;

    private String zipcode;

    private String phone;

    private List<PutInspectionCommand> inspections;

    public PutRestaurantCommand(String name, String borough, String street, String zipcode, String phone, List<PutInspectionCommand> inspections) {
        this.name = name;
        this.borough = borough;
        this.street = street;
        this.zipcode = zipcode;
        this.phone = phone;
        this.inspections = inspections;
    }

    public PutRestaurantCommand() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public List<PutInspectionCommand> getInspections() {
        return inspections;
    }

    public void setInspections(List<PutInspectionCommand> inspections) {
        this.inspections = inspections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PutRestaurantCommand that = (PutRestaurantCommand) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getBorough(), that.getBorough()) && Objects.equals(getStreet(), that.getStreet()) && Objects.equals(getZipcode(), that.getZipcode()) && Objects.equals(getPhone(), that.getPhone()) && Objects.equals(getInspections(), that.getInspections());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBorough(), getStreet(), getZipcode(), getPhone(), getInspections());
    }
}
