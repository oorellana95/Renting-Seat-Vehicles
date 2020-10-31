/*package com.mybackend.seat.application.factories;

import com.mybackend.seat.application.domain.entities.FuelsourcesEntity;
import com.mybackend.seat.application.models.FuelsourcesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//--- Factory -------------------------------------------------------
@Component
public class FuelsourcesFactory {

    //--- Constructor -----------------------------------------------
    @Autowired
    public FuelsourcesFactory() {
    }

    //--- Functions -------------------------------------------------
    public FuelsourcesEntity createEntity(FuelsourcesModel model){
        FuelsourcesEntity entity = new FuelsourcesEntity();
        entity.setId(model.id);
        entity.setName(model.name);
        entity.setDescription(model.description);
        return entity;
    }

    public FuelsourcesModel createModel(FuelsourcesEntity entity){
        FuelsourcesModel model = new FuelsourcesModel();
        model.id = entity.getId();
        model.name = entity.getName();
        model.description = entity.getDescription();
        return model;
    }
}*/
