package com.mybackend.seat.application.models;

import com.mybackend.seat.application.domain.entities.OffersEntity;

import java.util.List;

public class MobilitytypesModel {

    //--- Attributes -----------------------------------------------
    public long id;
    public String name;
    public String description;

    //--- Constructor ----------------------------------------------
    public MobilitytypesModel() {
    }

    public MobilitytypesModel(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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
}
