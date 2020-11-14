package com.mybackend.seat.utils.DiscountUtilTests;

import com.mybackend.seat.SeatRentingApplication;
import com.mybackend.seat.api.dto.OffersPricesDTO;
import com.mybackend.seat.application.models.OffersModel;
import com.mybackend.seat.utils.DiscountUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SeatRentingApplication.class)
public class GetBestNonCumulativeOfferTest {
    SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");

    @Autowired
    DiscountUtil discountUtil;

    @Test //Testing: There is always only 1 offer as a result. If there are no real offers, the one will have a discount of 0.
    public void ShouldReturnOffersSize1() throws Exception {
        Date checkIn = f.parse("2020/01/01");
        Date checkOut = f.parse("2020/01/10");
        double pricePerDay = 100;
        List<OffersModel> offers = new ArrayList<>();


        OffersPricesDTO dto = discountUtil.getBestNonCumulativeOffer(offers, checkIn, checkOut, pricePerDay);
        assertEquals(1, dto.offers.size());
        assertEquals(0, dto.offers.get(0).discountAppliedInRevenues);
    }

    @Test //Testing: When there is no offers, the finalTotalDiscount is also 0
    public void ShouldReturnFinalTotalDiscount0() throws Exception {
        Date checkIn = f.parse("2020/01/01");
        Date checkOut = f.parse("2020/01/10");
        List<OffersModel> offers = new ArrayList<>();
        double pricePerDay = 100;

        OffersPricesDTO dto = discountUtil.getBestNonCumulativeOffer(offers, checkIn, checkOut, pricePerDay);
        assertEquals(0, dto.finalTotalDiscount);
    }

    @Test //Testing: When there is offers, get the best one
    public void ShouldReturnFinalTotalDiscount100() throws Exception {
        Date checkIn = f.parse("2020/01/01");
        Date checkOut = f.parse("2020/01/10");
        List<OffersModel> offers = new ArrayList<>();
        offers.add(new OffersModel(1, c(f.parse("2020/01/01")), c(f.parse("2020/01/10")), "absolute", 10));
        offers.add(new OffersModel(2, c(f.parse("2020/01/01")), c(f.parse("2020/01/01")), "absolute", 50));
        double pricePerDay = 100;

        OffersPricesDTO dto = discountUtil.getBestNonCumulativeOffer(offers, checkIn, checkOut, pricePerDay);
        assertEquals(1, dto.offers.get(0).id);
        assertEquals(100, dto.finalTotalDiscount);
    }

    @Test //Testing: When there is offers, get the best one for the client, independently if the offers are in proportional or absolute terms
    public void ShouldReturnFinalTotalDiscount200() throws Exception {
        Date checkIn = f.parse("2020/01/01");
        Date checkOut = f.parse("2020/01/10");
        List<OffersModel> offers = new ArrayList<>();
        offers.add(new OffersModel(1, c(f.parse("2020/01/01")), c(f.parse("2020/01/10")), "absolute", 10));
        offers.add(new OffersModel(2, c(f.parse("2020/01/01")), c(f.parse("2020/01/10")), "proportional", 0.2));
        double pricePerDay = 100;

        OffersPricesDTO dto = discountUtil.getBestNonCumulativeOffer(offers, checkIn, checkOut, pricePerDay);
        assertEquals(2, dto.offers.get(0).id);
        assertEquals(200, dto.finalTotalDiscount);
    }

    private static java.sql.Date c(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

}
