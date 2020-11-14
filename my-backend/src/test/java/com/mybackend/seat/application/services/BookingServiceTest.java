package com.mybackend.seat.application.services;

import com.mybackend.seat.SeatRentingApplication;
import com.mybackend.seat.application.models.BookingsModel;
import com.mybackend.seat.application.models.VehiclesModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SeatRentingApplication.class)
public class BookingServiceTest {
    SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");

    @Autowired
    private BookingsService bookingsService;

    @Autowired
    private VehiclesService vehiclesService;

    @Test
    public void ShouldinjectedBean()
    {
        assertThat(bookingsService).isNotNull();
    }

    @Test
    public void ShouldAddBookingInDatabaseWhenSave() throws Exception {
        VehiclesModel vehicle = vehiclesService.findById(1);
        BookingsModel model = new BookingsModel(
                c(f.parse("2020/01/01")),
                c(f.parse("2020/01/10")),
                200.00,
                "Oscar Orellana",
                "oorellana@gmail.com",
                vehicle);

        BookingsModel data =  bookingsService.save(model);
        assertThat(data.getClient()).isEqualTo(model.getClient());
    }

    private static java.sql.Date c(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
}