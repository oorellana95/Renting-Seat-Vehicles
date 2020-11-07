package com.mybackend.seat.ui.dto;

import com.mybackend.seat.application.models.OffersModel;

import java.util.ArrayList;
import java.util.List;

public class OffersPricesDTO {
    public List<OffersModel> offers;
    public double finalTotalPrice;
    public double finalTotalDiscount;
    public double defaultTotalPrice;
    public long totalDays;

    public OffersPricesDTO() {
        this.offers = new ArrayList<>();
    }

    public List<OffersModel> getOffers() {
        return offers;
    }
    public void setOffers(List<OffersModel> offers) {
        this.offers = offers;
    }

    public double getFinalTotalPrice() {
        return finalTotalPrice;
    }
    public void setFinalTotalPrice(double finalTotalPrice) {
        this.finalTotalPrice = finalTotalPrice;
    }

    public double getFinalTotalDiscount() {
        return finalTotalDiscount;
    }
    public void setFinalTotalDiscount(double finalTotalDiscount) {
        this.finalTotalDiscount = finalTotalDiscount;
    }

    public double getDefaultTotalPrice() {
        return defaultTotalPrice;
    }
    public void setDefaultTotalPrice(double defaultTotalPrice) {
        this.defaultTotalPrice = defaultTotalPrice;
    }

    public long getTotalDays() {
        return totalDays;
    }
    public void setTotalDays(long totalDays) {
        this.totalDays = totalDays;
    }
}
