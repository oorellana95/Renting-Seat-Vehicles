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
    @Column(name = "name", nullable = true, length=100)
    private String name;

    @Basic
    @Column(name = "description", nullable = true, length=500)
    private String description;
    @Basic
    @Column(name = "specificDescription", nullable = true, length=500)
    private String specificDescription;

    @Basic
    @Column(name = "pricePerDay", nullable = true, precision = 0)
    private Double pricePerDay;

    @Basic
    @Column(name = "image", nullable = true, length=100)
    private String image;

    @Basic
    @Column(name = "passengers", nullable = true)
    private int passengers;

    @Basic
    @Column(name = "gearbox", nullable = true, length=50)
    private String gearbox;

    @ManyToOne
    @JoinColumn(name = "fk_mobilitytype_id", referencedColumnName = "id", table = "vehicles")
    private MobilitytypesEntity mobilityType;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "offers_vehicles",
            joinColumns = @JoinColumn(name = "fk_vehicle_id", referencedColumnName = "id", table = "vehicles"),
            inverseJoinColumns = @JoinColumn(name = "fk_offer_id", referencedColumnName = "id", table = "offers"))
    private List<OffersEntity> offersVehicles;

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

    public String getSpecificDescription() {
        return specificDescription;
    }
    public void setSpecificDescription(String specificDescription) {
        this.specificDescription = specificDescription;
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

    public List<OffersEntity> getOffers() {
        return offersVehicles;
    }
    public void setOffers(List<OffersEntity> offers) {
        this.offersVehicles = offers;
    }

    //--- Some general functions -----------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehiclesEntity that = (VehiclesEntity) o;
        return id == that.id &&
                passengers == that.passengers &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(specificDescription, that.specificDescription) &&
                Objects.equals(pricePerDay, that.pricePerDay) &&
                Objects.equals(image, that.image) &&
                Objects.equals(gearbox, that.gearbox) &&
                Objects.equals(mobilityType, that.mobilityType) &&
                Objects.equals(offersVehicles, that.offersVehicles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, specificDescription, pricePerDay, image, passengers, gearbox, mobilityType, offersVehicles);
    }
}
