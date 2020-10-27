package com.mybackend.seat.utils;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class bookingLogicalService {
    DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    //--- Functions ----------------------------------------------------
    public double calculateTotalPrice(Date checkIn, Date checkOut, double pricePerNight) {
        long nights = getDaysBetweenTwoDates(checkIn, checkOut);
        double totalPrice = nights * pricePerNight;
        return totalPrice;
    }

    public Date stringToDate(String date) {
        return Date.valueOf( LocalDate.parse(date, inputFormat).format(outputFormat) );
    }

    public long getDaysBetweenTwoDates(Date date1, Date date2) {
        return TimeUnit.DAYS.convert((date2.getTime() - date1.getTime()), TimeUnit.MILLISECONDS);
    }

}

