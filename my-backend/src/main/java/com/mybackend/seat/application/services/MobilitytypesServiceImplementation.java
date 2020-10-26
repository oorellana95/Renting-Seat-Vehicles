package com.mybackend.seat.application.services;

import com.mybackend.seat.application.factories.MobilitytypesFactory;
import com.mybackend.seat.application.domain.entities.MobilitytypesEntity;
import com.mybackend.seat.application.models.MobilitytypesModel;
import com.mybackend.seat.application.domain.repositories.MobilitytypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//--- Service ----------------------------------------------------------
@Service
public class MobilitytypesServiceImplementation implements MobilitytypesService {

    //--- Repositories & Factories needed ------------------------------
    MobilitytypesRepository repository;
    MobilitytypesFactory factory;

    //--- Constructor --------------------------------------------------
    @Autowired
    public MobilitytypesServiceImplementation(MobilitytypesRepository repository, MobilitytypesFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    //--- Functions ----------------------------------------------------
    @Override
    public MobilitytypesModel findById(long id) {
        return factory.createModel(repository.findById(id).get());
    }

    @Override
    public List<MobilitytypesModel> findAll() {
        List<MobilitytypesEntity> entities = repository.findAll();
        List<MobilitytypesModel> models = entities.stream().map(entity -> {
            return factory.createModel(entity);
        }).collect(Collectors.toList());
        return models;
    }

    @Override
    public void save(MobilitytypesModel model) {
        repository.save(factory.createEntity(model));
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(MobilitytypesModel model) {
        repository.delete(factory.createEntity(model));
    }

}
