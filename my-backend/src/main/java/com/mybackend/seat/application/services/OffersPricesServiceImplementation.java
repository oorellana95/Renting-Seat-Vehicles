package com.mybackend.seat.application.services;

import com.mybackend.seat.application.domain.entities.OffersEntity;
import com.mybackend.seat.application.domain.entities.VehiclesEntity;
import com.mybackend.seat.application.domain.repositories.OffersRepository;
import com.mybackend.seat.application.domain.repositories.VehiclesRepository;
import com.mybackend.seat.application.factories.OffersFactory;
import com.mybackend.seat.application.models.OffersModel;
import com.mybackend.seat.utils.PricesUtil;
import com.mybackend.seat.utils.PricesUtilImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

//--- Service ----------------------------------------------------------
@Service
public class OffersPricesServiceImplementation implements OffersPricesService{
    //--- Repositories & Factories needed ------------------------------
    VehiclesRepository vehiclesRepository;
    PricesUtil pricesUtil;

    //--- Constructor --------------------------------------------------
    @Autowired
    public OffersPricesServiceImplementation(VehiclesRepository vehiclesRepository, PricesUtil pricesUtil) {
        this.vehiclesRepository = vehiclesRepository;
        this.pricesUtil = pricesUtil;
    }

    //--- Functions ----------------------------------------------------
    @Override
    public double applyOffersToPrice(long id, Date checkin, Date checkout) {
        VehiclesEntity vehicle = vehiclesRepository.findById(id).orElse(new VehiclesEntity());

        //Merging vehicles and mobility-type offers
        Set<OffersEntity> offers = new HashSet<OffersEntity>(vehicle.getOffers());
        offers.addAll(vehicle.getMobilityType().getOffers());

        //Separating types of offers.
        List<OffersEntity> offers_cumu_abs = offers.stream().filter(o -> o.isCumulative() && o.getType().equals("absolute") && (new Date()).before(o.getEndDate())).collect(Collectors.toList());
        List<OffersEntity> offers_cumu_prop = offers.stream().filter(o -> o.isCumulative() && o.getType().equals("proportional") && (new Date()).before(o.getEndDate())).collect(Collectors.toList());

        List<OffersEntity> offers_noncumu_abs = offers.stream().filter(o -> !o.isCumulative() && o.getType().equals("absolute") && (new Date()).before(o.getEndDate())).collect(Collectors.toList());
        List<OffersEntity> offers_noncumu_prop = offers.stream().filter(o -> !o.isCumulative() && o.getType().equals("proportional") && (new Date()).before(o.getEndDate())).collect(Collectors.toList());



        double hola = pricesUtil.calculateDiscountAbsolute(checkin,checkout,offers_cumu_abs.get(0));

        //Debo devolver el precio final y todas las ofertas aplicadas
        return hola;
    }

}
