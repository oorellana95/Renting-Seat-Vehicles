package com.mybackend.seat.application.services;

import com.mybackend.seat.application.domain.entities.OffersEntity;
import com.mybackend.seat.application.domain.entities.VehiclesEntity;
import com.mybackend.seat.application.domain.repositories.OffersRepository;
import com.mybackend.seat.application.domain.repositories.VehiclesRepository;
import com.mybackend.seat.application.factories.OffersFactory;
import com.mybackend.seat.application.models.OffersModel;
import com.mybackend.seat.ui.dto.OffersPricesDTO;
import com.mybackend.seat.utils.DiscountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

//--- Service ----------------------------------------------------------
@Service
public class OffersPricesServiceImplementation implements OffersPricesService{
    //--- Repositories & Factories needed ------------------------------
    VehiclesRepository vehiclesRepository;
    OffersService offersService;
    DiscountUtil discountUtil;

    //--- Constructor --------------------------------------------------
    @Autowired
    public OffersPricesServiceImplementation(VehiclesRepository vehiclesRepository, OffersService offersService, DiscountUtil discountUtil) {
        this.vehiclesRepository = vehiclesRepository;
        this.offersService = offersService;
        this.discountUtil = discountUtil;
    }

    //--- Functions ----------------------------------------------------
    @Override
    public OffersPricesDTO getOffersAndPrice(long id, Date checkin, Date checkout) {
        VehiclesEntity vehicle = vehiclesRepository.findById(id).orElse(new VehiclesEntity());

        //Merging vehicles and mobility-type offers
        List<OffersModel> offers = getArrayAllOffers(vehicle);

        //Cumulative DTO
        OffersPricesDTO dto = discountUtil.getAllAppliedOffersAndTotalDiscount(offers, checkin, checkout, vehicle.getPricePerDay());
        dto.defaultTotalPrice = discountUtil.getDefaultPrice(checkin, checkout, vehicle.getPricePerDay());
        dto.finalTotalPrice = discountUtil.getFinalPrice(dto.defaultTotalPrice, dto.finalTotalDiscount);
        return dto;
    }

    public List<OffersModel> getArrayAllOffers(VehiclesEntity vehicle){
        Set<OffersEntity> offersEntities = new HashSet<OffersEntity>();

        if (vehicle.getOffers().size() > 0 ) {
            offersEntities.addAll(vehicle.getOffers());
        }

        if (vehicle.getMobilityType().getOffers().size() > 0) {
            offersEntities.addAll(vehicle.getMobilityType().getOffers());
        }

        return offersService.entitiesToModel(offersEntities);
    }
}
