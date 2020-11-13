package com.mybackend.seat.application.services;

import com.mybackend.seat.application.domain.entities.VehiclesEntity;
import com.mybackend.seat.application.models.OffersModel;
import com.mybackend.seat.api.dto.OffersPricesDTO;

import java.util.Date;
import java.util.List;

//--- Service Interface -------------------------------------------
public interface OffersPricesService {
    OffersPricesDTO getOffersAndPrice(long id, Date checkin, Date checkout);
    List<OffersModel> getArrayAllOffers(VehiclesEntity vehicle);
    double getFinalPrice(long id, Date checkin, Date checkout);
}
