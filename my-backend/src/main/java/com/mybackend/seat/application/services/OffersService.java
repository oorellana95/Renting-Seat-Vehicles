package com.mybackend.seat.application.services;

import com.mybackend.seat.application.models.OffersModel;

import java.util.List;

//--- Service Interface -------------------------------------------
public interface OffersService {

    OffersModel findById(long id);

    List<OffersModel> findAll();

    void save(OffersModel model);

    void deleteById(long id);

    void delete(OffersModel model);

}
