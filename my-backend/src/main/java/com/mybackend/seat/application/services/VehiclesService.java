package com.mybackend.seat.application.services;

import com.mybackend.seat.application.models.VehiclesModel;

import java.util.List;

//--- Service Interface -------------------------------------------
public interface VehiclesService {

    VehiclesModel findById(long id);

    List<VehiclesModel> findAll();

    List<VehiclesModel> findApplyingFilter(int minPrice, int maxPrice, long idMobilityType);

    void save(VehiclesModel model);

    void deleteById(long id);

    void delete(VehiclesModel model);

}
