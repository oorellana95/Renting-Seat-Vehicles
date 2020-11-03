package com.mybackend.seat.application.domain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

//--- Entity -------------------------------------------------------
@Entity
@Table(name = "mobilitytypes", schema = "seat_renting")
public class MobilitytypesEntity implements Serializable {

    //--- Attributes -----------------------------------------------
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Basic
    @Column(name = "name", nullable = true, length=100)
    private String name;

    @Basic
    @Column(name = "description", nullable = true, length=300)
    private String description;

    @OneToMany(mappedBy = "mobilityType")
    private List<VehiclesEntity> vehicles;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "offers_mobilitytypes",
            joinColumns = @JoinColumn(name = "fk_mobilitytype_id", referencedColumnName = "id", table = "mobilitytypes"),
            inverseJoinColumns = @JoinColumn(name = "fk_offer_id", referencedColumnName = "id", table = "offers"))
    private List<OffersEntity> offersMobilityTypes;


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

    public List<VehiclesEntity> getVehicles() {
        return vehicles;
    }
    public void setVehicles(List<VehiclesEntity> vehicles) {
        this.vehicles = vehicles;
    }

    public List<OffersEntity> getOffers() {
        return offersMobilityTypes;
    }
    public void setOffers(List<OffersEntity> offers) {
        this.offersMobilityTypes = offers;
    }

    //--- Some general functions -----------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MobilitytypesEntity that = (MobilitytypesEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(vehicles, that.vehicles) &&
                Objects.equals(offersMobilityTypes, that.offersMobilityTypes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, vehicles, offersMobilityTypes);
    }
}
