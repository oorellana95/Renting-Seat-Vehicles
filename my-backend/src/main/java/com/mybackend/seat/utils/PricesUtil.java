package com.mybackend.seat.utils;

import com.mybackend.seat.application.domain.entities.OffersEntity;

import java.util.Date;

public interface PricesUtil {
    long getDaysBetweenTwoDates(Date date1, Date date2);
    double calculateTotalPrice(Date checkIn, Date checkOut, double defaultPrice);
    double calculateDiscountAbsolute(Date checkIn, Date checkOut, OffersEntity offer);
}
