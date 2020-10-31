/*package com.mybackend.seat.application.factories;

import com.mybackend.seat.application.domain.entities.LoginsEntity;
import com.mybackend.seat.application.models.LoginsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//--- Factory -------------------------------------------------------
@Component
public class LoginsFactory {

    //--- Needed Factories ------------------------------------------
    private ClientsFactory clientsFactory;

    //--- Constructor -----------------------------------------------
    @Autowired
    public LoginsFactory(ClientsFactory clientsFactory) {
        this.clientsFactory = clientsFactory;
    }

    //--- Functions -------------------------------------------------
    public LoginsEntity createEntity(LoginsModel model){
        LoginsEntity entity = new LoginsEntity();
        entity.setId(model.id);
        entity.setUsername(model.username);
        entity.setPassword(model.password);
        entity.setClient(clientsFactory.createEntity(model.client));
        entity.setRole("ROLE_CLIENT");
        entity.setEnabled(true);
        return entity;
    }
    public LoginsModel createModel(LoginsEntity entity){
        LoginsModel model = new LoginsModel();
        model.id = entity.getId();
        model.username = entity.getUsername();
        model.password = entity.getPassword();
        model.client = clientsFactory.createModel(entity.getClient());
        return model;
    }
}*/