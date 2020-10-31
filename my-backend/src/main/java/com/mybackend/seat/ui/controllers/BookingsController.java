package com.mybackend.seat.ui.controllers;

import com.mybackend.seat.application.models.BookingsModel;
import com.mybackend.seat.application.models.VehiclesModel;
import com.mybackend.seat.application.services.BookingsService;
import com.mybackend.seat.application.services.VehiclesService;
import com.mybackend.seat.ui.dto.BookingsDTO;
import com.mybackend.seat.utils.PricesUtilImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/bookings")
public class BookingsController {
    BookingsService bookingsService;
    PricesUtilImplementation pricesUtilImplementation;
    VehiclesService vehiclesService;

    //--- Constructor -----------------------------------------------------
    @Autowired
    public BookingsController(BookingsService bookingsService, PricesUtilImplementation pricesUtilImplementation, VehiclesService vehiclesService) {
        this.bookingsService = bookingsService;
        this.vehiclesService = vehiclesService;
        this.pricesUtilImplementation = pricesUtilImplementation;
    }

    @GetMapping("/")
    public List<BookingsModel> getAllBookings() {
        return bookingsService.findAll();
    }

    @GetMapping("/{id}")
    public BookingsModel getBookingById(@PathVariable("id") long id) {
        return bookingsService.findById(id);
    }

    @PostMapping("/post-booking")
    @ResponseBody
    public BookingsModel postBooking(@RequestBody BookingsDTO dto) {
        VehiclesModel vehicle = vehiclesService.findById(dto.id_vehicle);
        double price = pricesUtilImplementation.calculateTotalPrice(dto.checkIn, dto.checkOut, vehicle.pricePerDay);

        BookingsModel model = new BookingsModel(dto.checkIn, dto.checkOut, price, dto.client, dto.email, vehicle);
        bookingsService.save(model);
        return model;
    }

}
