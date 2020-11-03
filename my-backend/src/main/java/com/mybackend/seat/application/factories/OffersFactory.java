package com.mybackend.seat.application.factories;

import com.mybackend.seat.application.domain.entities.OffersEntity;
import com.mybackend.seat.application.models.OffersModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OffersFactory {

    //--- Constructor -----------------------------------------------
    @Autowired
    public OffersFactory() {
    }

    //--- Functions -------------------------------------------------
    public OffersEntity createEntity(OffersModel model){
        OffersEntity entity = new OffersEntity();
        entity.setId(model.id);
        entity.setName(model.name);
        entity.setDescription(model.description);
        entity.setStartDate(model.startDate);
        entity.setEndDate(model.endDate);
        entity.setCumulative(model.cumulative);
        entity.setType(model.type);
        entity.setQuantity(model.quantity);

        return entity;
    }

    public OffersModel createModel(OffersEntity entity){
        OffersModel model = new OffersModel();
        model.id = entity.getId();
        model.name = entity.getName();
        model.description = entity.getDescription();
        model.startDate = entity.getStartDate();
        model.endDate = entity.getEndDate();
        model.cumulative = entity.isCumulative();
        model.type = entity.getType();
        model.quantity = entity.getQuantity();

        return model;
    }
}
