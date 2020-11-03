package com.mybackend.seat.application.services;

import com.mybackend.seat.application.domain.entities.OffersEntity;
import com.mybackend.seat.application.domain.repositories.OffersRepository;
import com.mybackend.seat.application.factories.OffersFactory;
import com.mybackend.seat.application.models.OffersModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//--- Service ----------------------------------------------------------
@Service
public class OffersServiceImplementation implements OffersService {
    //--- Repositories & Factories needed ------------------------------
    OffersRepository repository;
    OffersFactory factory;

    //--- Constructor --------------------------------------------------
    @Autowired
    public OffersServiceImplementation(OffersRepository repository, OffersFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    //--- Functions ----------------------------------------------------
    @Override
    public OffersModel findById(long id) {
        return factory.createModel(repository.findById(id).get());
    }

    @Override
    public List<OffersModel> findAll() {
        List<OffersEntity> entities = repository.findAll();
        List<OffersModel> models = entities.stream().map(entity -> {
            return factory.createModel(entity);
        }).collect(Collectors.toList());
        return models;
    }

    @Override
    public void save(OffersModel model) {
        repository.save(factory.createEntity(model));
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(OffersModel model) {
        repository.delete(factory.createEntity(model));
    }
}
