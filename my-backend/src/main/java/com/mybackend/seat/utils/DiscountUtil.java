package com.mybackend.seat.utils;

import com.mybackend.seat.application.models.OffersModel;
import com.mybackend.seat.api.dto.OffersPricesDTO;

import java.util.Date;
import java.util.List;

public interface DiscountUtil {
    long getDaysBetweenTwoDates(Date date1, Date date2);
    long getDaysToApplyOffer(Date checkIn, Date checkOut, Date startOffer, Date endOffer);

    double absoluteDiscountInRevenues(long days, double absoluteDiscount);
    double proportionalDiscountInRevenues(long days, double pricePerDay, double percentageDiscount);

    OffersPricesDTO getBestNonCumulativeOffer(List<OffersModel> offers, Date checkIn, Date checkOut, double pricePerDay);
    OffersPricesDTO getCumulativeOffers(List<OffersModel> offers, Date checkIn, Date checkOut, double pricePerDay);
    OffersPricesDTO getAllAppliedOffersAndTotalDiscount(List<OffersModel> offers, Date checkIn, Date checkOut, double pricePerDay);

    double getDefaultPrice(Date checkIn, Date checkOut, double pricePerDay);
    double getFinalPrice(double defaultPrice, double discounts);
}
