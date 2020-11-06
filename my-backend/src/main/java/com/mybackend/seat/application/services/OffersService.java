package com.mybackend.seat.application.services;

import com.mybackend.seat.application.domain.entities.OffersEntity;
import com.mybackend.seat.application.models.OffersModel;

import java.util.List;
import java.util.Set;

//--- Service Interface -------------------------------------------
public interface OffersService {

    OffersModel findById(long id);

    List<OffersModel> findAll();

    List<OffersModel> entitiesToModel(Set<OffersEntity> entities);

    void save(OffersModel model);

    void deleteById(long id);

    void delete(OffersModel model);

}
