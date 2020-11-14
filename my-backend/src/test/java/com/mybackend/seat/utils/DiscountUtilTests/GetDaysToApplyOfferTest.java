package com.mybackend.seat.utils.DiscountUtilTests;

import com.mybackend.seat.SeatRentingApplication;
import com.mybackend.seat.utils.DiscountUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SeatRentingApplication.class)
public class GetDaysToApplyOfferTest {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

    @Autowired
    DiscountUtil discountUtil;

    @Test //Testing: offerIn < offerOut < checkIn  < checkOut
    public void ShouldReturn0() throws Exception {
        Date checkIn = formatter.parse("2020/01/01");
        Date checkOut = formatter.parse("2020/01/31");
        Date offerIn = formatter.parse("2019/02/01");
        Date offerOut = formatter.parse("2019/05/01");
        assertEquals(0, discountUtil.getDaysToApplyOffer(checkIn, checkOut, offerIn, offerOut));
    }

    @Test //Testing: checkIn  < checkOut < offerIn < offerOut
    public void ShouldReturnAlso0() throws Exception {
        Date checkIn = formatter.parse("2020/01/01");
        Date checkOut = formatter.parse("2020/01/31");
        Date offerIn = formatter.parse("2020/02/01");
        Date offerOut = formatter.parse("2020/05/01");
        assertEquals(0, discountUtil.getDaysToApplyOffer(checkIn, checkOut, offerIn, offerOut));
    }

    @Test //Testing: offerIn < checkIn  < checkOut < offerOut
    public void ShouldReturn31() throws Exception {
        Date checkIn = formatter.parse("2020/01/01");
        Date checkOut = formatter.parse("2020/01/31");
        Date offerIn = formatter.parse("2019/12/01");
        Date offerOut = formatter.parse("2020/02/01");
        assertEquals(31, discountUtil.getDaysToApplyOffer(checkIn, checkOut, offerIn, offerOut));
    }

    @Test //Testing: offerIn == checkIn  < checkOut == offerOut
    public void ShouldReturn10() throws Exception {
        Date checkIn = formatter.parse("2020/01/01");
        Date checkOut = formatter.parse("2020/01/10");
        Date offerIn = formatter.parse("2020/01/01");
        Date offerOut = formatter.parse("2020/01/10");
        assertEquals(10,discountUtil.getDaysToApplyOffer(checkIn, checkOut, offerIn, offerOut));
    }

    @Test //Testing: offerIn == checkIn  == checkOut < offerOut
    public void ShouldReturn1() throws Exception {
        Date checkIn = formatter.parse("2020/01/01");
        Date checkOut = formatter.parse("2020/01/01");
        Date offerIn = formatter.parse("2020/01/01");
        Date offerOut = formatter.parse("2020/01/10");
        assertEquals(1, discountUtil.getDaysToApplyOffer(checkIn, checkOut, offerIn, offerOut));
    }

    @Test //Testing: offerIn < checkIn < offerOut < checkOut
    public void ShouldReturn2() throws Exception {
        Date offerIn = formatter.parse("2020/01/01");
        Date checkIn = formatter.parse("2020/01/02");
        Date offerOut = formatter.parse("2020/01/04");
        Date checkOut = formatter.parse("2020/01/20");
        assertEquals(3, discountUtil.getDaysToApplyOffer(checkIn, checkOut, offerIn, offerOut));
    }

    @Test //Testing: offerIn < checkIn < offerOut == checkOut
    public void ShouldReturn4() throws Exception {
        Date offerIn = formatter.parse("2020/01/01");
        Date checkIn = formatter.parse("2020/01/02");
        Date offerOut = formatter.parse("2020/01/05");
        Date checkOut = formatter.parse("2020/01/05");
        assertEquals(4, discountUtil.getDaysToApplyOffer(checkIn, checkOut, offerIn, offerOut));
    }

    @Test //Testing: checkIn < offerIn < offerOut < checkOut
    public void ShouldReturn5() throws Exception {
        Date checkIn = formatter.parse("2020/01/01");
        Date offerIn = formatter.parse("2020/01/20");
        Date offerOut = formatter.parse("2020/01/24");
        Date checkOut = formatter.parse("2020/01/27");
        assertEquals(5, discountUtil.getDaysToApplyOffer(checkIn, checkOut, offerIn, offerOut));
    }

    @Test //Testing: checkIn =< offerIn < offerOut < checkOut
    public void ShouldReturn6() throws Exception {
        Date checkIn = formatter.parse("2020/01/20");
        Date offerIn = formatter.parse("2020/01/20");
        Date offerOut = formatter.parse("2020/01/25");
        Date checkOut = formatter.parse("2020/01/26");
        assertEquals(6, discountUtil.getDaysToApplyOffer(checkIn, checkOut, offerIn, offerOut));
    }

    @Test //Testing: checkIn < offerIn < checkOut < offerOut
    public void ShouldReturn7() throws Exception {
        Date checkIn = formatter.parse("2020/01/01");
        Date offerIn = formatter.parse("2020/01/20");
        Date checkOut = formatter.parse("2020/01/26");
        Date offerOut = formatter.parse("2020/01/27");
        assertEquals(7, discountUtil.getDaysToApplyOffer(checkIn, checkOut, offerIn, offerOut));
    }

    @Test //Testing: checkIn =< offerIn < checkOut < offerOut
    public void ShouldReturn8() throws Exception {
        Date checkIn = formatter.parse("2020/01/20");
        Date offerIn = formatter.parse("2020/01/20");
        Date checkOut = formatter.parse("2020/01/27");
        Date offerOut = formatter.parse("2020/01/28");
        assertEquals(8, discountUtil.getDaysToApplyOffer(checkIn, checkOut, offerIn, offerOut));
    }
}
