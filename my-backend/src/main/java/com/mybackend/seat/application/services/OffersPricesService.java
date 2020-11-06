package com.mybackend.seat.application.services;

import com.mybackend.seat.ui.dto.OffersPricesDTO;

import java.util.Date;

//--- Service Interface -------------------------------------------
public interface OffersPricesService {
    OffersPricesDTO getOffersAndPrice(long id, Date checkin, Date checkout);
}
