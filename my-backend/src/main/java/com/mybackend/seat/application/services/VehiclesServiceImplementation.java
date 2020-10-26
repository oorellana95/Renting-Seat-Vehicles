package com.mybackend.seat.application.services;

import com.mybackend.seat.application.factories.VehiclesFactory;
import com.mybackend.seat.application.domain.entities.VehiclesEntity;
import com.mybackend.seat.application.models.VehiclesModel;
import com.mybackend.seat.application.domain.repositories.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//--- Service ----------------------------------------------------------
@Service
public class VehiclesServiceImplementation implements VehiclesService {

    //--- Repositories & Factories needed ------------------------------
    VehiclesRepository repository;
    VehiclesFactory factory;

    //--- Constructor --------------------------------------------------
    @Autowired
    public VehiclesServiceImplementation(VehiclesRepository repository, VehiclesFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    //--- Functions ----------------------------------------------------
    @Override
    public VehiclesModel findById(long id) {
        return factory.createModel(repository.findById(id).get());
    }

    @Override
    public List<VehiclesModel> findAll() {
        List<VehiclesEntity> entities = repository.findAll();
        List<VehiclesModel> models = entities.stream().map(entity -> {
            return factory.createModel(entity);
        }).collect(Collectors.toList());
        return models;
    }

    @Override
    public List<VehiclesModel> findApplyingFilter(int minPrice, int maxPrice, long idMobilityType){
        List<VehiclesEntity> entities = repository.findApplyingFilter(minPrice, maxPrice, idMobilityType);
        List<VehiclesModel> models = entities.stream().map(entity -> {
            return factory.createModel(entity);
        }).collect(Collectors.toList());
        return models;
    }

    @Override
    public void save(VehiclesModel model) {
        repository.save(factory.createEntity(model));
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(VehiclesModel model) {
        repository.delete(factory.createEntity(model));
    }

}
