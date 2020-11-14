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
public class GetCumulativeOffersTest {
    SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");

    @Autowired
    DiscountUtil discountUtil;

    @Test //Testing: The different offers have to be considered, adding value to the finalTotalDiscount.
    public void ShouldReturnFinalTotalDiscount350() throws Exception {
        Date checkIn = f.parse("2020/01/01");
        Date checkOut = f.parse("2020/01/10");
        List<OffersModel> offers = new ArrayList<>();
        offers.add(new OffersModel(1, c(f.parse("2020/01/01")), c(f.parse("2020/01/10")), "absolute", 10));
        offers.add(new OffersModel(2, c(f.parse("2020/01/01")), c(f.parse("2020/01/01")), "absolute", 50));
        offers.add(new OffersModel(3, c(f.parse("2020/01/01")), c(f.parse("2020/01/10")), "proportional", 0.2));
        double pricePerDay = 100;

        OffersPricesDTO dto = discountUtil.getCumulativeOffers(offers, checkIn, checkOut, pricePerDay);
        assertEquals(100, dto.offers.get(0).discountAppliedInRevenues);
        assertEquals(50, dto.offers.get(1).discountAppliedInRevenues);
        assertEquals(200, dto.offers.get(2).discountAppliedInRevenues);
        assertEquals(350, dto.finalTotalDiscount);
    }

    @Test //Testing: Should accept extra charges or negative discounts
    public void ShouldReturnFinalTotalDiscountMinus350() throws Exception {
        Date checkIn = f.parse("2020/01/01");
        Date checkOut = f.parse("2020/01/10");
        List<OffersModel> offers = new ArrayList<>();
        offers.add(new OffersModel(1, c(f.parse("2020/01/01")), c(f.parse("2020/01/10")), "absolute", -10));
        offers.add(new OffersModel(2, c(f.parse("2020/01/01")), c(f.parse("2020/01/01")), "absolute", -50));
        offers.add(new OffersModel(3, c(f.parse("2020/01/01")), c(f.parse("2020/01/10")), "proportional", -0.2));
        double pricePerDay = 100;

        OffersPricesDTO dto = discountUtil.getCumulativeOffers(offers, checkIn, checkOut, pricePerDay);
        assertEquals(-100, dto.offers.get(0).discountAppliedInRevenues);
        assertEquals(-50, dto.offers.get(1).discountAppliedInRevenues);
        assertEquals(-200, dto.offers.get(2).discountAppliedInRevenues);
        assertEquals(-350, dto.finalTotalDiscount);
    }

    private static java.sql.Date c(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
}
