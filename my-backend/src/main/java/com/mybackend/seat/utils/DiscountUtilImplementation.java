package com.mybackend.seat.utils;

import com.mybackend.seat.application.models.OffersModel;
import com.mybackend.seat.api.dto.OffersPricesDTO;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
public class DiscountUtilImplementation implements DiscountUtil {

    //--- Functions ----------------------------------------------------
    @Override
    public long getDaysBetweenTwoDates(Date date1, Date date2) {
        return TimeUnit.DAYS.convert((date2.getTime() - date1.getTime() ), TimeUnit.MILLISECONDS) + 1;
    }

    @Override
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
    public double absoluteDiscountInRevenues(long days, double absoluteDiscount) {
        return days * absoluteDiscount;
    }

    @Override
    public double proportionalDiscountInRevenues(long days, double pricePerDay, double percentageDiscount) {
        return days * pricePerDay * percentageDiscount;
    }

    @Override
    public OffersPricesDTO getBestNonCumulativeOffer(List<OffersModel> offers, Date checkIn, Date checkOut, double pricePerDay){
        double bestDiscount = 0;
        OffersModel bestOffer = new OffersModel();

        for (OffersModel offer : offers)
        {
            double currentDiscount = 0;
            long days = getDaysToApplyOffer(checkIn, checkOut, offer.getStartDate(), offer.getEndDate());

            if ((offer.getType().equals("absolute"))){
                currentDiscount = absoluteDiscountInRevenues(days, offer.getQuantity());
            }

            else if ((offer.getType().equals("proportional"))){
                currentDiscount = proportionalDiscountInRevenues(days, pricePerDay, offer.getQuantity());
            }

            if (currentDiscount > bestDiscount){
                bestDiscount = currentDiscount;
                bestOffer = offer;
            }
        }
        bestOffer.discountAppliedInRevenues = bestDiscount;

        //No me gusta aqui
        OffersPricesDTO dto = new OffersPricesDTO();
        dto.offers.add(bestOffer);
        dto.finalTotalDiscount = bestDiscount;

        return dto;
    }

    @Override
    public OffersPricesDTO getCumulativeOffers(List<OffersModel> offers, Date checkIn, Date checkOut, double pricePerDay){
        double totalDiscount = 0;
        for (OffersModel offer : offers)
        {
            long days = getDaysToApplyOffer(checkIn, checkOut, offer.getStartDate(), offer.getEndDate());
            double discount = 0;

            if ((offer.getType().equals("absolute"))){
                discount = absoluteDiscountInRevenues(days, offer.getQuantity());
            }

            else if ((offer.getType().equals("proportional"))){
                discount = proportionalDiscountInRevenues(days, pricePerDay, offer.getQuantity());
            }
            offer.discountAppliedInRevenues = discount;
            totalDiscount += discount;
        }

        //No me gusta aqui
        OffersPricesDTO dto = new OffersPricesDTO();
        dto.setOffers(offers);
        dto.finalTotalDiscount = totalDiscount;

        return dto;
    }

    @Override
    public double getDefaultPrice(Date checkIn, Date checkOut, double pricePerDay){
        long days = getDaysBetweenTwoDates(checkIn, checkOut);
        return days * pricePerDay;
    }

    @Override
    public OffersPricesDTO getAllAppliedOffersAndTotalDiscount(List<OffersModel> offers, Date checkin, Date checkout, double pricePerDay){
        List<OffersModel> offers_cumu = offers.stream().filter(o -> o.isCumulative() && (new Date()).before(o.getEndDate())).collect(Collectors.toList());
        OffersPricesDTO dtoCumulative = getCumulativeOffers(offers_cumu, checkin, checkout, pricePerDay);

        List<OffersModel> offers_noncumu = offers.stream().filter(o -> !o.isCumulative() && (new Date()).before(o.getEndDate())).collect(Collectors.toList());
        OffersPricesDTO dtoNonCumulative = getBestNonCumulativeOffer(offers_noncumu, checkin, checkout, pricePerDay);

        if (dtoNonCumulative.finalTotalDiscount > dtoCumulative.finalTotalDiscount) {
            return dtoNonCumulative;
        }
        else {
            return dtoCumulative;
        }
    }

    @Override
    public double getFinalPrice(double defaultPrice, double discounts){
        return  Math.round((defaultPrice-discounts)*100.0)/100.0;
    }
}
