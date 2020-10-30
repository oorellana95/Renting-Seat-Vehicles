package com.mybackend.seat.utils;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@Component
public class PricesUtilImplementation {
    DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    //--- Functions ----------------------------------------------------
    public Date stringToDate(String date) {
        return Date.valueOf( LocalDate.parse(date, inputFormat).format(outputFormat) );
    }

    public long getDaysBetweenTwoDates(Date date1, Date date2) {
        return TimeUnit.DAYS.convert((date2.getTime() - date1.getTime() ), TimeUnit.MILLISECONDS);
    }

    public double calculateTotalPrice(Date checkIn, Date checkOut, double defaultPrice) {
        long days = getDaysBetweenTwoDates(checkIn, checkOut) + 1;
        double totalPrice = days * defaultPrice;
        return totalPrice;
    }
}
