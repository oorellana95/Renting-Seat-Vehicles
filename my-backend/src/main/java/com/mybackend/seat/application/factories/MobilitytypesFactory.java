package com.mybackend.seat.application.factories;

import com.mybackend.seat.application.domain.entities.MobilitytypesEntity;
import com.mybackend.seat.application.models.MobilitytypesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

//--- Factory -------------------------------------------------------
@Component
public class MobilitytypesFactory {
    private OffersFactory offersFactory;

    //--- Constructor -----------------------------------------------
    @Autowired
    public MobilitytypesFactory(OffersFactory offersFactory) {
        this.offersFactory = offersFactory;
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
