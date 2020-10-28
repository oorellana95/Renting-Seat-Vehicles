package com.mybackend.seat.application.factories;

import com.mybackend.seat.application.domain.entities.VehiclesEntity;
import com.mybackend.seat.application.models.VehiclesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//--- Factory -------------------------------------------------------
@Component
public class VehiclesFactory {

    //--- Needed Factories ------------------------------------------
    private MobilitytypesFactory mobilitytypesFactory;

    //--- Constructor -----------------------------------------------
    @Autowired
    public VehiclesFactory(MobilitytypesFactory mobilitytypesFactory) {
        this.mobilitytypesFactory = mobilitytypesFactory;
    }

    //--- Functions -------------------------------------------------
    public VehiclesEntity createEntity(VehiclesModel model){
        VehiclesEntity entity = new VehiclesEntity();
        entity.setId(model.id);
        entity.setName(model.name);
        entity.setDescription(model.description);
        entity.setPricePerDay(model.pricePerDay);
        entity.setImage(model.image);
        entity.setGearbox(model.gearbox);
        entity.setPassengers(model.passengers);
        entity.setMobilityType(mobilitytypesFactory.createEntity(model.mobilityType));
        return entity;
    }

    public VehiclesModel createModel(VehiclesEntity entity){
        VehiclesModel model = new VehiclesModel();
        model.id = entity.getId();
        model.name = entity.getName();
        model.description = entity.getDescription();
        model.pricePerDay = entity.getPricePerDay();
        model.image = entity.getImage();
        model.passengers = entity.getPassengers();
        model.gearbox = entity.getGearbox();
        model.mobilityType = mobilitytypesFactory.createModel(entity.getMobilityType());
        return model;
    }
}
