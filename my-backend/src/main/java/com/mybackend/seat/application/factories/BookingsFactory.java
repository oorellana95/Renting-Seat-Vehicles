package com.mybackend.seat.application.factories;

import com.mybackend.seat.application.domain.entities.BookingsEntity;
import com.mybackend.seat.application.models.BookingsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//--- Factory -------------------------------------------------------
@Component
public class BookingsFactory {

    //--- Needed Factories ------------------------------------------
    VehiclesFactory vehiclesFactory;

    //--- Constructor -----------------------------------------------
    @Autowired
    public BookingsFactory(VehiclesFactory vehiclesFactory) {
        this.vehiclesFactory = vehiclesFactory;
    }

    //--- Functions -------------------------------------------------
    public BookingsEntity createEntity(BookingsModel model){
        BookingsEntity entity = new BookingsEntity();
        entity.setId(model.id);
        entity.setCheckIn(model.checkIn);
        entity.setCheckOut(model.checkOut);
        entity.setTotalPrice(model.totalPrice);
        entity.setClient(model.client);
        entity.setEmail(model.email);
        entity.setVehicle(vehiclesFactory.createEntity(model.vehicle));
        return entity;
    }

    public BookingsModel createModel(BookingsEntity entity){
        BookingsModel model = new BookingsModel();
        model.id = entity.getId();
        model.checkIn = entity.getCheckIn();
        model.checkOut = entity.getCheckOut();
        model.totalPrice = entity.getTotalPrice();
        model.email = entity.getEmail();
        model.client = entity.getClient();
        model.vehicle = vehiclesFactory.createModel(entity.getVehicle());
        return model;
    }
}