package com.mybackend.seat.application.models;

public class VehiclesModel {

    //--- Attributes -----------------------------------------------
    public long id;
    public String name;
    public String description;
    public Double pricePerDay;
    public String image;
    public MobilitytypesModel mobilityType;

    //--- Constructor ----------------------------------------------
    public VehiclesModel() {
    }

    //--- Getters & Setters ----------------------------------------
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

    public MobilitytypesModel getMobilityType() {
        return mobilityType;
    }
    public void setMobilityType(MobilitytypesModel mobilityType) {
        this.mobilityType = mobilityType;
    }

}
