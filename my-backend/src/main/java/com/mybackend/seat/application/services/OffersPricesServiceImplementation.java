package com.mybackend.seat.application.services;

import com.mybackend.seat.application.domain.entities.OffersEntity;
import com.mybackend.seat.application.domain.entities.VehiclesEntity;
import com.mybackend.seat.application.domain.repositories.OffersRepository;
import com.mybackend.seat.application.domain.repositories.VehiclesRepository;
import com.mybackend.seat.application.factories.OffersFactory;
import com.mybackend.seat.application.models.OffersModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//--- Service ----------------------------------------------------------
@Service
public class OffersPricesServiceImplementation implements OffersPricesService{
    //--- Repositories & Factories needed ------------------------------
    VehiclesRepository vehiclesRepository;

    //--- Constructor --------------------------------------------------
    @Autowired
    public OffersPricesServiceImplementation(VehiclesRepository vehiclesRepository) {
        this.vehiclesRepository = vehiclesRepository;
    }

    //--- Functions ----------------------------------------------------
    @Override
    public void applyOffersToPrice(long id, Date checkin, Date checkout) {
        VehiclesEntity vehiclesEntity = vehiclesRepository.findById(id).orElse(new VehiclesEntity());
        Set<OffersEntity> offers = new HashSet<OffersEntity>(vehiclesEntity.getOffers());
        offers.addAll(vehiclesEntity.getMobilityType().getOffers());
        System.out.println("Hola");
    }

}
