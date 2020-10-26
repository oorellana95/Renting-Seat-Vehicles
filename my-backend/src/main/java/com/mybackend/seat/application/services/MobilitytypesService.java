package com.mybackend.seat.application.services;

import com.mybackend.seat.application.models.MobilitytypesModel;

import java.util.List;

//--- Service Interface -------------------------------------------
public interface MobilitytypesService {

    MobilitytypesModel findById(long id);

    List<MobilitytypesModel> findAll();

    void save(MobilitytypesModel model);

    void deleteById(long id);

    void delete(MobilitytypesModel model);

}
