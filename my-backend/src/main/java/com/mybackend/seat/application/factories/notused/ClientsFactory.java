/*package com.mybackend.seat.application.factories;

import com.mybackend.seat.application.domain.entities.ClientsEntity;
import com.mybackend.seat.application.models.ClientsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//--- Factory -------------------------------------------------------
@Component
public class ClientsFactory {

    //--- Constructor -----------------------------------------------
    @Autowired
    public ClientsFactory() {
    }

    //--- Functions -------------------------------------------------
    public ClientsEntity createEntity(ClientsModel model){
        ClientsEntity entity = new ClientsEntity();
        entity.setId(model.id);
        entity.setName(model.name);
        entity.setLastname(model.lastname);
        entity.setEmail(model.email);

        return entity;
    }

    public ClientsModel createModel(ClientsEntity entity){
        ClientsModel model = new ClientsModel();
        model.id = entity.getId();
        model.name = entity.getName();
        model.lastname = entity.getLastname();
        model.email = entity.getEmail();

        return model;
    }
}*/