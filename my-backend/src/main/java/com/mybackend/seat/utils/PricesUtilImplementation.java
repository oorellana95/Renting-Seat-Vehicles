package com.mybackend.seat.utils;

import com.mybackend.seat.application.domain.entities.OffersEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@Component
public class PricesUtilImplementation implements PricesUtil {
    DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    //--- Functions ----------------------------------------------------
    @Override
    public long getDaysBetweenTwoDates(Date date1, Date date2) {
        return TimeUnit.DAYS.convert((date2.getTime() - date1.getTime() ), TimeUnit.MILLISECONDS) + 1;
    }

    public long getDaysToApplyOffer(Date checkIn, Date checkOut, Date startOffer, Date endOffer){
        long days = 0;
        if (startOffer.before(checkIn) && checkOut.before(endOffer)){
            days = getDaysBetweenTwoDates(checkIn, checkOut);
        }
        else if (startOffer.before(checkIn) && checkIn.before(endOffer) && endOffer.before(checkOut)){
            days = getDaysBetweenTwoDates(checkIn, endOffer);
        }
        else if (checkIn.before(startOffer) && endOffer.before(checkOut)){
            days = getDaysBetweenTwoDates(startOffer, endOffer);
        }
        else if (checkIn.before(startOffer) && startOffer.before(checkOut) && checkOut.before(endOffer)){
            days = getDaysBetweenTwoDates(startOffer, checkOut);
        }
        return days;
    }

    @Override
    public double calculateTotalPrice(Date checkIn, Date checkOut, double pricePerDay) {
        long days = getDaysBetweenTwoDates(checkIn, checkOut);
        return days * pricePerDay;
    }

    public double calculateDiscountAbsolute(Date checkIn, Date checkOut, OffersEntity offer) {
        long days = getDaysToApplyOffer(checkIn, checkOut, offer.getStartDate(), offer.getEndDate());
        return days * offer.getQuantity();
    }

    public double calculateDiscountProportional(Date checkIn, Date checkOut, double pricePerDay, OffersEntity offer) {
        long days = getDaysToApplyOffer(checkIn, checkOut, offer.getStartDate(), offer.getEndDate());
        return days * pricePerDay * offer.getQuantity();
    }
}
