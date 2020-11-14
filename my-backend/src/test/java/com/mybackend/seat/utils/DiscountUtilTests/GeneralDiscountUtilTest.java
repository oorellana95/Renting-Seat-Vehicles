package com.mybackend.seat.utils.DiscountUtilTests;

import com.mybackend.seat.SeatRentingApplication;
import com.mybackend.seat.utils.DiscountUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SeatRentingApplication.class)
public class GeneralDiscountUtilTest {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

    @Autowired
    DiscountUtil discountUtil;

    //------------------------------ Function: getDaysBetween() ---------------------------------//

    @Test
    public void GetDaysBetweenShouldReturn3Days() throws Exception {
        Date date1 = formatter.parse("2020/10/01");
        Date date2 = formatter.parse("2020/10/03");
        assertEquals(3, discountUtil.getDaysBetweenTwoDates(date1,date2));
    }

    @Test
    public void GetDaysBetweenShouldReturn365Days() throws Exception {
        Date date1 = formatter.parse("2023/1/01");
        Date date2 = formatter.parse("2023/12/31");
        assertEquals(365,discountUtil.getDaysBetweenTwoDates(date1,date2));
    }

    //---------------- Functions: Calculation Absolute & Proportional Discounts -----------------//


    @Test
    public void AbsoluteDiscountInRevenuesShouldReturn20() throws Exception {
        assertEquals(20,discountUtil.absoluteDiscountInRevenues(2,10));
    }

    @Test
    public void ProportionalDiscountInRevenuesShouldReturn10() throws Exception {
        assertEquals(10,discountUtil.proportionalDiscountInRevenues(10,10, 0.1));
    }

    //---------------------- Functions: Calculation Default & Final Price ----------------------//
    @Test
    public void GetDefaultPriceShouldReturn100() throws Exception {
        Date checkIn = formatter.parse("2020/10/01");
        Date checkOut = formatter.parse("2020/10/10");
        assertEquals(100,discountUtil.getDefaultPrice(checkIn,checkOut, 10));
    }

    @Test
    public void GetFinalPriceShouldReturn100() throws Exception {
        assertEquals(100,discountUtil.getFinalPrice(200, 100));
    }

}