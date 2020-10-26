package com.mybackend.seat.application.domain.entities;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

//--- Entity -------------------------------------------------------
@Entity
@Table(name = "fuelsources", schema = "seat_renting")
public class FuelsourcesEntity implements Serializable {

    //--- Attributes -----------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Basic
    @Column(name = "name", nullable = true)
    private String name;

    @Basic
    @Column(name = "description", nullable = true)
    private String description;

    @ManyToMany(mappedBy = "fuelSources")
    private List<VehiclesEntity> vehicles;

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

    //--- Some general functions -----------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuelsourcesEntity that = (FuelsourcesEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(vehicles, that.vehicles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, vehicles);
    }
}

