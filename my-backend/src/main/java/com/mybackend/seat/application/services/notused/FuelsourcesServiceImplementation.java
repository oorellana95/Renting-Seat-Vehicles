/*package com.mybackend.seat.application.services;

import com.mybackend.seat.application.factories.FuelsourcesFactory;
import com.mybackend.seat.application.domain.entities.FuelsourcesEntity;
import com.mybackend.seat.application.models.FuelsourcesModel;
import com.mybackend.seat.application.domain.repositories.FuelsourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//--- Service ----------------------------------------------------------
@Service
public class FuelsourcesServiceImplementation implements FuelsourcesService {

    //--- Repositories & Factories needed ------------------------------
    FuelsourcesRepository repository;
    FuelsourcesFactory factory;

    //--- Constructor --------------------------------------------------
    @Autowired
    public FuelsourcesServiceImplementation(FuelsourcesRepository repository, FuelsourcesFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    //--- Functions ----------------------------------------------------
    @Override
    public FuelsourcesModel findById(long id) {
        return factory.createModel(repository.findById(id).get());
    }

    @Override
    public List<FuelsourcesModel> findAll() {
        List<FuelsourcesEntity> entities = repository.findAll();
        List<FuelsourcesModel> models = entities.stream().map(entity -> {
            return factory.createModel(entity);
        }).collect(Collectors.toList());
        return models;
    }

    @Override
    public void save(FuelsourcesModel model) {
        repository.save(factory.createEntity(model));
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(FuelsourcesModel model) {
        repository.delete(factory.createEntity(model));
    }

}*/
