package com.mybackend.seat.application.services;

import java.util.Date;

//--- Service Interface -------------------------------------------
public interface OffersPricesService {
    void applyOffersToPrice(long id, Date checkin, Date checkout);
}
