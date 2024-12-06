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
    private Integer camis;
    private String name;
    private String borough;
    private String building;
    private String street;
    private String zipcode;
    private String phone;
    private Double latitude;
    private Double longitude;
    private String communityBoard;
    private String councilDistrict;
    private String censusTract;
    private String bin;
    private String bbl;
    private String nta;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Inspections> inspections;

    public Restaurants(Integer camis, String name, String borough, String building, String street, String zipcode, String phone, Double latitude, Double longitude, String communityBoard, String councilDistrict, String censusTract, String bin, String bbl, String nta, List<Inspections> inspections) {
        this.camis = camis;
        this.name = name;
        this.borough = borough;
        this.building = building;
        this.street = street;
        this.zipcode = zipcode;
        this.phone = phone;
        this.latitude = latitude;
        this.longitude = longitude;
        this.communityBoard = communityBoard;
        this.councilDistrict = councilDistrict;
        this.censusTract = censusTract;
        this.bin = bin;
        this.bbl = bbl;
        this.nta = nta;
        this.inspections = inspections;
    }

    public Restaurants() {
    }

    public Integer getCamis() {
        return camis;
    }

    public void setCamis(Integer camis) {
        this.camis = camis;
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

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getCommunityBoard() {
        return communityBoard;
    }

    public void setCommunityBoard(String communityBoard) {
        this.communityBoard = communityBoard;
    }

    public String getCouncilDistrict() {
        return councilDistrict;
    }

    public void setCouncilDistrict(String councilDistrict) {
        this.councilDistrict = councilDistrict;
    }

    public String getCensusTract() {
        return censusTract;
    }

    public void setCensusTract(String censusTract) {
        this.censusTract = censusTract;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getBbl() {
        return bbl;
    }

    public void setBbl(String bbl) {
        this.bbl = bbl;
    }

    public String getNta() {
        return nta;
    }

    public void setNta(String nta) {
        this.nta = nta;
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
        return Objects.equals(getCamis(), that.getCamis()) && Objects.equals(getName(), that.getName()) && Objects.equals(getBorough(), that.getBorough()) && Objects.equals(getBuilding(), that.getBuilding()) && Objects.equals(getStreet(), that.getStreet()) && Objects.equals(getZipcode(), that.getZipcode()) && Objects.equals(getPhone(), that.getPhone()) && Objects.equals(getLatitude(), that.getLatitude()) && Objects.equals(getLongitude(), that.getLongitude()) && Objects.equals(getCommunityBoard(), that.getCommunityBoard()) && Objects.equals(getCouncilDistrict(), that.getCouncilDistrict()) && Objects.equals(getCensusTract(), that.getCensusTract()) && Objects.equals(getBin(), that.getBin()) && Objects.equals(getBbl(), that.getBbl()) && Objects.equals(getNta(), that.getNta()) && Objects.equals(getInspections(), that.getInspections());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCamis(), getName(), getBorough(), getBuilding(), getStreet(), getZipcode(), getPhone(), getLatitude(), getLongitude(), getCommunityBoard(), getCouncilDistrict(), getCensusTract(), getBin(), getBbl(), getNta(), getInspections());
    }
}


