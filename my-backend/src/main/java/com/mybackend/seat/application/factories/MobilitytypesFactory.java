package com.mybackend.seat.application.factories;

import com.mybackend.seat.application.domain.entities.MobilitytypesEntity;
import com.mybackend.seat.application.models.MobilitytypesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//--- Factory -------------------------------------------------------
@Component
public class MobilitytypesFactory {

    //--- Constructor -----------------------------------------------
    @Autowired
    public MobilitytypesFactory() {
    }

    //--- Functions -------------------------------------------------
    public MobilitytypesEntity createEntity(MobilitytypesModel model){
        MobilitytypesEntity entity = new MobilitytypesEntity();
        entity.setId(model.id);
        entity.setName(model.name);
        entity.setDescription(model.description);
        return entity;
    }

    public MobilitytypesModel createModel(MobilitytypesEntity entity){
        MobilitytypesModel model = new MobilitytypesModel();
        model.id = entity.getId();
        model.name = entity.getName();
        model.description = entity.getDescription();
        return model;
    }
}
