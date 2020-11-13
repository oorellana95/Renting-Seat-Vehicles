package com.mybackend.seat.application.services;

import com.mybackend.seat.application.domain.entities.OffersEntity;
import com.mybackend.seat.application.domain.entities.VehiclesEntity;
import com.mybackend.seat.application.domain.repositories.VehiclesRepository;
import com.mybackend.seat.application.models.OffersModel;
import com.mybackend.seat.api.dto.OffersPricesDTO;
import com.mybackend.seat.utils.DiscountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
        dto.totalDays = discountUtil.getDaysBetweenTwoDates(checkin, checkout);
        dto.defaultTotalPrice = discountUtil.getDefaultPrice(checkin, checkout, vehicle.getPricePerDay());
        dto.finalTotalPrice = discountUtil.getFinalPrice(dto.defaultTotalPrice, dto.finalTotalDiscount);
        return dto;
    }

    @Override
    public double getFinalPrice(long id, Date checkin, Date checkout) {
        VehiclesEntity vehicle = vehiclesRepository.findById(id).orElse(new VehiclesEntity());

        //Merging vehicles and mobility-type offers
        List<OffersModel> offers = getArrayAllOffers(vehicle);

        //Cumulative DTO
        double discount = discountUtil.getAllAppliedOffersAndTotalDiscount(offers, checkin, checkout, vehicle.getPricePerDay()).finalTotalDiscount;
        double defaultPrice = discountUtil.getDefaultPrice(checkin, checkout, vehicle.getPricePerDay());
        double finalPrice = discountUtil.getFinalPrice(defaultPrice, discount);
        return finalPrice;
    }

    @Override
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
