package com.mybackend.seat.application.domain.entities;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

//--- Entity -------------------------------------------------------
@Entity
@Table(name = "offers", schema = "seat_renting")
public class OffersEntity implements Serializable {

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

    @Basic
    @Column(name = "startDate", nullable = true)
    private Date startDate;

    @Basic
    @Column(name = "endDate", nullable = true)
    private Date endDate;

    @Basic
    @Column(name = "cumulative", nullable = true)
    private boolean cumulative;

    @Basic
    @Column(name = "type", nullable = true)
    private String type;

    @Basic
    @Column(name = "quantity", nullable = true)
    private double quantity;

    @ManyToMany(mappedBy = "offers")
    private List<VehiclesEntity> vehicles;

    @ManyToMany(mappedBy = "offers")
    private List<MobilitytypesEntity> mobilitytypesEntities;

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

    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isCumulative() {
        return cumulative;
    }
    public void setCumulative(boolean cumulative) {
        this.cumulative = cumulative;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public double getQuantity() {
        return quantity;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public List<VehiclesEntity> getVehicles() {
        return vehicles;
    }
    public void setVehicles(List<VehiclesEntity> vehicles) {
        this.vehicles = vehicles;
    }

    public List<MobilitytypesEntity> getMobilitytypesEntities() {
        return mobilitytypesEntities;
    }
    public void setMobilitytypesEntities(List<MobilitytypesEntity> mobilitytypesEntities) {
        this.mobilitytypesEntities = mobilitytypesEntities;
    }

    //--- Some general functions -----------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OffersEntity that = (OffersEntity) o;
        return id == that.id &&
                cumulative == that.cumulative &&
                Double.compare(that.quantity, quantity) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(type, that.type) &&
                Objects.equals(vehicles, that.vehicles) &&
                Objects.equals(mobilitytypesEntities, that.mobilitytypesEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, startDate, endDate, cumulative, type, quantity, vehicles, mobilitytypesEntities);
    }
}