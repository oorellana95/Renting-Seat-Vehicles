package com.mybackend.seat.ui.controllers;

import com.mybackend.seat.application.models.BookingsModel;
import com.mybackend.seat.application.models.VehiclesModel;
import com.mybackend.seat.application.services.BookingsService;
import com.mybackend.seat.application.services.OffersPricesService;
import com.mybackend.seat.application.services.VehiclesService;
import com.mybackend.seat.ui.dto.BookingsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/bookings")
public class BookingsController {
    BookingsService bookingsService;
    VehiclesService vehiclesService;
    OffersPricesService offersPricesServices;

    //--- Constructor -----------------------------------------------------
    @Autowired
    public BookingsController(BookingsService bookingsService, VehiclesService vehiclesService, OffersPricesService offersPricesServices) {
        this.bookingsService = bookingsService;
        this.vehiclesService = vehiclesService;
        this.offersPricesServices = offersPricesServices;
    }

    @PostMapping("/post-booking")
    @ResponseBody
    public BookingsModel postBooking(@RequestBody BookingsDTO dto) {
        VehiclesModel vehicle = vehiclesService.findById(dto.id_vehicle);
        double price = offersPricesServices.getFinalPrice(vehicle.id, dto.checkIn, dto.checkOut);

        BookingsModel model = new BookingsModel(dto.checkIn, dto.checkOut, price, dto.client, dto.email, vehicle);
        return bookingsService.save(model);
    }

}
