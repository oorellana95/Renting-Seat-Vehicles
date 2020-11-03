package com.mybackend.seat.application.factories;

import com.mybackend.seat.application.domain.entities.OffersEntity;
import com.mybackend.seat.application.domain.entities.VehiclesEntity;
import com.mybackend.seat.application.models.OffersModel;
import com.mybackend.seat.application.models.VehiclesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//--- Factory -------------------------------------------------------
@Component
public class VehiclesFactory {

    //--- Needed Factories ------------------------------------------
    private MobilitytypesFactory mobilitytypesFactory;
    private OffersFactory offersFactory;

    //--- Constructor -----------------------------------------------
    @Autowired
    public VehiclesFactory(MobilitytypesFactory mobilitytypesFactory, OffersFactory offersFactory) {
        this.mobilitytypesFactory = mobilitytypesFactory;
        this.offersFactory = offersFactory;
    }

    //--- Functions -------------------------------------------------
    public VehiclesEntity createEntity(VehiclesModel model){
        VehiclesEntity entity = new VehiclesEntity();
        List<OffersEntity> list;

        entity.setId(model.id);
        entity.setName(model.name);
        entity.setDescription(model.description);
        entity.setSpecificDescription(model.specificDescription);
        entity.setPricePerDay(model.pricePerDay);
        entity.setImage(model.image);
        entity.setGearbox(model.gearbox);
        entity.setPassengers(model.passengers);
        entity.setMobilityType(mobilitytypesFactory.createEntity(model.mobilityType));
        return entity;
    }

    public VehiclesModel createModel(VehiclesEntity entity){
        VehiclesModel model = new VehiclesModel();
        List<OffersModel> list;
        model.id = entity.getId();
        model.name = entity.getName();
        model.description = entity.getDescription();
        model.specificDescription = entity.getSpecificDescription();
        model.pricePerDay = entity.getPricePerDay();
        model.image = entity.getImage();
        model.passengers = entity.getPassengers();
        model.gearbox = entity.getGearbox();
        model.mobilityType = mobilitytypesFactory.createModel(entity.getMobilityType());

        return model;
    }
}
