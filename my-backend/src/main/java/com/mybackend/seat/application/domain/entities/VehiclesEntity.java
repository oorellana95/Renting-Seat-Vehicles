package com.mybackend.seat.application.domain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

//--- Entity -------------------------------------------------------
@Entity
@Table(name = "vehicles", schema = "seat_renting")
public class VehiclesEntity implements Serializable {

    //--- Attributes -----------------------------------------------
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Basic
    @Column(name = "name", nullable = true)
    private String name;

    @Basic
    @Column(name = "description", nullable = true)
    private String description;

    @Basic
    @Column(name = "pricePerDay", nullable = true, precision = 0)
    private Double pricePerDay;

    @Basic
    @Column(name = "image", nullable = true)
    private String image;

    @Basic
    @Column(name = "passengers", nullable = true)
    private int passengers;

    @Basic
    @Column(name = "gearbox", nullable = true)
    private String gearbox;

    @ManyToOne
    @JoinColumn(name = "fk_mobilitytype_id", referencedColumnName = "id", table = "vehicles")
    private MobilitytypesEntity mobilityType;

    @ManyToMany
    @JoinTable(
            name = "vehicles_fuelsources",
            joinColumns = @JoinColumn(name = "fk_vehicle_id", referencedColumnName = "id", table = "vehicles"),
            inverseJoinColumns = @JoinColumn(name = "fk_fuelsource_id", referencedColumnName = "id", table = "fuelsources"))
    private List<FuelsourcesEntity> fuelSources;

    //--- Getters & Setters ---------------------------------------
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }
    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public MobilitytypesEntity getMobilityType() {
        return mobilityType;
    }
    public void setMobilityType(MobilitytypesEntity mobilitytype) {
        this.mobilityType = mobilitytype;
    }

    public List<FuelsourcesEntity> getFuelSources() {
        return fuelSources;
    }
    public void setFuelSources(List<FuelsourcesEntity> fuelSources) {
        this.fuelSources = fuelSources;
    }

    public int getPassengers() {
        return passengers;
    }
    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public String getGearbox() {
        return gearbox;
    }
    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    //--- Some general functions -----------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehiclesEntity that = (VehiclesEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(pricePerDay, that.pricePerDay) &&
                Objects.equals(image, that.image) &&
                Objects.equals(mobilityType, that.mobilityType) &&
                Objects.equals(fuelSources, that.fuelSources);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, pricePerDay, image, mobilityType, fuelSources);
    }
}
